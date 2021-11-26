package Optimisation;

import Model.Customer;
import Model.Depot;
import Model.Location;
import Model.Route;

import java.util.List;

public class RouteModifier {
  // Each route has its own route modifier where basic operations will be done
  private int usedCapacity;
  private int numberOfCustomers;
  private Route route;
  private List<Integer> arrivalTimes;     // Arrive at location
  private List<Integer> startTimes;       // Start of service
  private List<Integer> departureTimes;   // End of service


  public RouteModifier(Route r) {
    route = r;
    numberOfCustomers = r.getVisits().size() - 2;
    arrivalTimes.set(0, route.getDeparture_time());
    startTimes.set(0, route.getDeparture_time());
    departureTimes.set(0, route.getDeparture_time());

    for (int i = 1; i <= numberOfCustomers; i++) {
      arrivalTimes.set(i,
          departureTimes.get(i - 1) + GlobalModifier.getTravelTime(
              route.getLocation(i - 1), route.getLocation(i)
          )
      );
      startTimes.set(i, route.getLocation(i).getStartTimeAfter(arrivalTimes.get(i)));
      departureTimes.set(i, startTimes.get(i) + route.getCustomer(i).getDuration());
    }
  }

  public Location removeLocationWithLongestWaitTime() {
    return null;
  }
}
