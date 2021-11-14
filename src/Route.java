import java.util.LinkedList;
import java.util.List;

public class Route {
  private List<Customer> route;
  private int startTime;
  private int endTime;

  public Route(List<Customer> route, int startTime, int endTime) {
    this.route = route;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public Route(){
    route = new LinkedList<>();
  }

  public void addCustomer(Customer c){
    route.add(c);
  }

  public boolean isFeasibleWith(Customer c){
    return false;
  }

   /* //EDT (ci) = max(EDT (ci−1) + T T (ci−1, ci), StartT Wi) + STi


    public int[] calculateEarliestDepartureTime() {
      int[] EDT = new int[route.size()];
      EDT[0]=0;
      for (int i = 1; i<EDT.length-2;i++) {
          EDT[i]= Math.max(EDT[i-1]+distance[i-1][i], route.get(i).time_windows.get(dat)) + route.get(i).getDuration();
      }
      return earliestDepartureTimes;
    }


    //LST (ci) = min(LST (ci+1) − T T (ci+1, ci) − STi, EndT Wi)

    public int[] calculateLatestStartingTime() {
      int [] latestStartingTimes = new int[route.size()];

      return solution;
    }

*/


}
