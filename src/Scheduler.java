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

    public Customer getClosest(Customer start, Set<Customer> customers) {
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
            Customer newCustomer = getClosest(newRoute.getRoute().get(newRoute.getRoute().size()-2), customers);
            customers.remove(newCustomer);

            //TODO isFesibleWith
            if (isFeasibleWith(newRoute,newCustomer)) {
                newRoute.getRoute().add(newRoute.getRoute().size()-2,newCustomer);
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
}
