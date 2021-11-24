package Model;

import java.util.LinkedList;
import java.util.List;

public class Route {
  private List<Location> visits;
  private int departure_time;
  private int endTime;
  private int capacity;
  private int duration;

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

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




}
