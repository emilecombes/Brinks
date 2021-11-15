import java.util.LinkedList;
import java.util.List;

public class Route {
  private List<Location> visits;
  private int departure_time;
  private int endTime;
  private int capacity;

  public int getDeparture_time() {
    return departure_time;
  }

  public void setDeparture_time(int departure_time) {
    this.departure_time = departure_time;
  }

  public Route(){
    visits = new LinkedList<>();
    capacity = 0;
  }

  public List<Location> getVisits() {
    return visits;
  }

  public void setVisits(List<Location> visits) {
    this.visits = visits;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }



  public int getEndTime() {
    return endTime;
  }

  public void setEndTime(int endTime) {
    this.endTime = endTime;
  }



  public void addCustomer(Customer c){
    visits.add(c);
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
