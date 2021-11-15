import java.util.*;

public class Scheduler {

    Input input;


    public Scheduler(Input input) {
        this.input=input;

    }

    public Day scheduleDay(int id,Set<Customer> customers) {
        Day day = new Day(id);
        for (Depot depot : input.depots) {
            Set<Customer> customerForThisDepot = new HashSet<>();
            for (Customer c : customers) {
                if (isClosestTo(c,depot)) {
                    customerForThisDepot.add(c);
                }
            }
            List<Route> routes = scheduleRoutesForDepot(depot,customerForThisDepot,day);
            day.addRoutes(routes);
        }

        return day;

    }

    public boolean isClosestTo(Customer c, Depot d) {
        boolean closest = true;
        int distance = input.times.get(d.getId()).get(c.getId());
        for (Depot de : input.depots) {
            if (input.times.get(de.getId()).get(c.getId())<distance) {
                closest =false;
            }
        }
        return closest;
    }

    public Customer getClosest(Location start, Set<Customer> customers) {
        int min = Integer.MAX_VALUE;
        Customer c = null;
        for (Customer destination : customers) {
            if (start.getId() != destination.getId() && input.times.get(start.getId()).get(destination.getId())<min) {
                min = input.times.get(start.getId()).get(destination.getId());
                c = destination;
            }
        }
        return c;



    }

    public List<Route> scheduleRoutesForDepot(Depot depot, Set<Customer> customers,Day day) {
        //MAKE ROUTE BY ADDING NEW CLOSEST LOCATION, MAKE NEW ROUTE IF FEASABILITY IS BROKEN
        //FINISH WHEN ALL LOCATIONS ARE SERVED
        List<Route> routes = new LinkedList<>();

        //1. CHECK DURATION OF ROUTE
        //2. CHECK MACIMUM CAPACITY
        //3. CHECK OPENINGSUREN VAN WINKEL(WINKEL IS SWS OPEN OP DEZE DAG)
        Route newRoute = new Route();

        //add start
        newRoute.addCustomer(depot);

        //add end
        newRoute.addCustomer(depot);


        while (!customers.isEmpty()) {
            Customer newCustomer = getClosest(newRoute.getVisits().get(newRoute.getVisits().size()-2), customers);
            customers.remove(newCustomer);

            //TODO isFesibleWith
            if (isFeasibleWith(newRoute,newCustomer, day.id)) {
                newRoute.getVisits().add(newRoute.getVisits().size()-2,newCustomer);
            } else {
                routes.add(newRoute);
                newRoute = new Route();

                //add start
                newRoute.addCustomer(depot);

                //add end
                newRoute.addCustomer(depot);
            }

        }

        return routes;
    }

    public boolean isFeasibleWith(Route route, Customer customer, int dayId) {
        route.getVisits().add(route.getVisits().size()-1,customer);
        boolean feasible = true;
        int maxCapacity = input.getCapacity();


        //check if maxcapacity is overschreden


        if (getCapacity(route)>maxCapacity) {
            feasible=false;
            route.setCapacity(route.getCapacity()-customer.getDemand());
            route.getVisits().remove(customer);
        }


        //check if route duration is to long
        if (input.max_route_dur<getDuration(route,dayId)) {
            feasible=false;
            route.setCapacity(route.getCapacity()-customer.getDemand());
            route.getVisits().remove(customer);
        }


        return feasible;
    }


    public int getCapacity(Route route) {
        for (int i = 1; i<route.getVisits().size()-1; i++) {
                route.setCapacity(route.getCapacity()+ ((Customer) route.getVisits().get(i)).getDemand());
        }
        return route.getCapacity();
    }


    public int getDuration(Route route, int dayId) {
        int[] EarliestDepartureTimes = calculateEDT(route,dayId);
        int[] LatestDepartureTimes = calculateLDT(route,dayId);
        route.setDeparture_time(LatestDepartureTimes[0]);

        int duration = EarliestDepartureTimes[EarliestDepartureTimes.length-1] - LatestDepartureTimes[0];
        return duration;
    }


    public int[] calculateEDT(Route route,int dayId) {
        int [] EDT = new int [route.getVisits().size()];


        for (int i = 1 ; i<EDT.length;i++) {
            if (route.getVisits().get(i) instanceof StaticCustomer ) {
                StaticCustomer customer = (StaticCustomer) route.getVisits().get(i);
                int TT = input.getTimes().get(route.getVisits().get(i-1).getId()).get(customer.getId());
                EDT[i] = Math.max(EDT[i-1]+ TT ,  customer.getTime_windows().get(dayId).getEarly()) + customer.getDur();
            } else if (route.getVisits().get(i) instanceof  DynamicCustomer) {
                DynamicCustomer customer = ((DynamicCustomer)  route.getVisits().get(i));
                int TT = input.getTimes().get(route.getVisits().get(i-1).getId()).get(customer.getId());
                EDT[i] = Math.max(EDT[i-1]+ TT ,  customer.getTime_windows().get(dayId).getEarly()) + customer.getDur();
            } else if (route.getVisits().get(i) instanceof Depot) {
                Depot depot = (Depot) route.getVisits().get(i);
                int TT = input.getTimes().get(route.getVisits().get(i-1).getId()).get(depot.getId());
                EDT[i] = Math.max(EDT[i-1]+ TT ,  depot.getTime_windows().get(dayId).getEarly()) ;
            }
        }
        return EDT;
    }



    public int[] calculateLDT(Route route,int dayId) {
        int [] LDT = new int[route.getVisits().size()];

        for (int i = LDT.length-1 ; i==0;i--) {
            if (route.getVisits().get(i) instanceof StaticCustomer) {
                StaticCustomer customer = (StaticCustomer) route.getVisits().get(i);
                int TT = input.getTimes().get(route.getVisits().get(i + 1).getId()).get(customer.getId());
                LDT[i] = Math.min(LDT[i + 1] + TT - customer.getDur(), customer.getTime_windows().get(dayId).getLate());
            } else if (route.getVisits().get(i) instanceof DynamicCustomer) {
                DynamicCustomer customer = ((DynamicCustomer) route.getVisits().get(i));
                int TT = input.getTimes().get(route.getVisits().get(i + 1).getId()).get(customer.getId());
                LDT[i] = Math.min(LDT[i + 1] + TT - customer.getDur(), customer.getTime_windows().get(dayId).getLate());
            } else if (route.getVisits().get(i) instanceof Depot) {
                Depot depot = (Depot) route.getVisits().get(i);
                int TT = input.getTimes().get(route.getVisits().get(i + 1).getId()).get(depot.getId());
                LDT[i] = Math.min(LDT[i + 1] + TT, depot.getTime_windows().get(dayId).getLate());
            }
        }
        return LDT;
    }
}
