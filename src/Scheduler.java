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
        System.out.println("Day  -----------" + day.id);
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
            Customer newCustomer = getClosest(newRoute.getVisits().get(newRoute.getVisits().size()-1), customers);
            customers.remove(newCustomer);

            //TODO isFesibleWith
            if (isFeasibleWith(newRoute,newCustomer, day.id)) {

                newRoute.getVisits().add(newRoute.getVisits().size()-1,newCustomer);
                updateRoute(newRoute,day.id);
            } else {

                routes.add(newRoute);
                newRoute = new Route();

                //add start
                newRoute.addCustomer(depot);
                //add end
                newRoute.addCustomer(depot);

                newRoute.getVisits().add(newRoute.getVisits().size()-1,newCustomer);
            }

        }
        routes.add(newRoute);

        return routes;
    }

    public boolean isFeasibleWith(Route route, Customer customer, int dayId) {

        route.getVisits().add(route.getVisits().size()-1,customer);
        System.out.println("before adding customer duration : " + route.getDuration() );
        updateRoute(route,dayId);
        System.out.println("after adding customer duration: " +route.getDuration());
        for (Location c : route.getVisits()) {
            System.out.println(c);
        }
        boolean feasible = true;
        int maxCapacity = input.getCapacity();


        //check if maxcapacity is overschreden
        if (updateCapacity(route)>maxCapacity) {
            feasible=false;

        }


        //check if route duration is to long
        if (input.max_route_dur< updateDuration(route,dayId)) {
            feasible=false;
        }

        //Check if all starting times are within the range
        int[] EarliestDepartureTimes = calculateEDT(route,dayId);
        int[] LatestStartTimes = calculateLST(route,dayId,EarliestDepartureTimes[EarliestDepartureTimes.length-1]);
        int [] durations = new int[route.getVisits().size()];

        for (int i =1 ; i<EarliestDepartureTimes.length-1;i++) {
            if (route.getVisits().get(i) instanceof Customer) {
                durations[i] = ((Customer) route.getVisits().get(i)).getDur();
            }
        }

        for ( int i =1 ; i< EarliestDepartureTimes.length;i++) {
            if (EarliestDepartureTimes[i-1]+durations[i]+input.getTimes().get(route.getVisits().get(i-1).getId()).get(route.getVisits().get(i).getId())>LatestStartTimes[i]) {
                feasible=false;
            }
        }



        route.getVisits().remove(customer);
        updateRoute(route,dayId);



        return feasible;
    }


    public void updateRoute(Route route, int dayId) {
        updateCapacity(route);
        updateDuration(route,dayId) ;
    }

    public int updateCapacity(Route route) {
        for (int i = 1; i<route.getVisits().size()-1; i++) {
                route.setCapacity(route.getCapacity()+ ((Customer) route.getVisits().get(i)).getDemand());
        }
        return route.getCapacity();
    }


    public int updateDuration(Route route, int dayId) {
        int[] EarliestDepartureTimes = calculateEDT(route,dayId);
        int[] LatestStartTimes = calculateLST(route,dayId,EarliestDepartureTimes[EarliestDepartureTimes.length-1]);
        route.setDeparture_time(LatestStartTimes[0]);
        int duration = EarliestDepartureTimes[EarliestDepartureTimes.length-1] - LatestStartTimes[0];

        route.setDuration(duration);
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



    public int[] calculateLST(Route route,int dayId, int startValue) {
        int [] LST = new int[route.getVisits().size()];
        LST[route.getVisits().size()-1] = startValue;

        for (int i = LST.length-2 ; i>-1;i--) {
            if (route.getVisits().get(i) instanceof StaticCustomer) {
                StaticCustomer customer = (StaticCustomer) route.getVisits().get(i);
                int TT = input.getTimes().get(customer.getId()).get(route.getVisits().get(i+1).getId());
                LST[i] = Math.min(LST[i + 1] - TT - customer.getDur(), customer.getTime_windows().get(dayId).getLate());
            } else if (route.getVisits().get(i) instanceof DynamicCustomer) {
                DynamicCustomer customer = ((DynamicCustomer) route.getVisits().get(i));
                int TT = input.getTimes().get(customer.getId()).get(route.getVisits().get(i+1).getId());                LST[i] = Math.min(LST[i + 1] - TT - customer.getDur(), customer.getTime_windows().get(dayId).getLate());
            } else if (route.getVisits().get(i) instanceof Depot) {
                Depot depot = (Depot) route.getVisits().get(i);
                int TT = input.getTimes().get(depot.getId()).get(route.getVisits().get(i+1).getId());
                LST[i] = Math.min(LST[i + 1] - TT, depot.getTime_windows().get(dayId).getLate());

            }
        }
        return LST;
    }

    public float calculateCostPerRoute(Route route) {
        int duration = route.getDuration();
        float serviceCost = duration*input.getCost_wage_minute();
        int distance = 0;
        for (int i = 1 ; i <route.getVisits().size();i++) {
            distance += input.getTimes().get(route.getVisits().get(i-1).getId()).get(route.getVisits().get(i).getId());
        }
        float fuelCost = distance*input.getCost_fuel_minute();
        return  serviceCost+fuelCost;

    }

    public float calculateCostPerDay(Day day) {
        float cost = 0;
        for (Route route : day.getRoutes()) {
            cost+=calculateCostPerRoute(route);
        }
        return cost;
    }

    public float calculateTotalCost(List<Day> days) {
        float cost = 0;
        for (Day day : days) {
            cost+=calculateCostPerDay(day);
        }
        return cost;
    }
}
