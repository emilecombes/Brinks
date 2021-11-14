import java.util.List;

public class DynamicCustomer extends Customer{
  Coordinaat coords;
  int demand;
  int dur;
  int id;
  List<TimeWindow> time_windows;

  public DynamicCustomer(Coordinaat coords, int demand, int dur, int id, List<TimeWindow> time_windows) {
    super();
    this.coords = coords;
    this.demand = demand;
    this.dur = dur;
    this.id = id;
    this.time_windows = time_windows;
  }

  @Override
  public Coordinaat getCoords() {
    return coords;
  }

  @Override
  public void setCoords(Coordinaat coords) {
    this.coords = coords;
  }

  public int getDemand() {
    return demand;
  }

  public void setDemand(int demand) {
    this.demand = demand;
  }

  public int getDur() {
    return dur;
  }

  public void setDur(int dur) {
    this.dur = dur;
  }

  @Override
  public int getId() {
    return id;
  }

  @Override
  public void setId(int id) {
    this.id = id;
  }

  @Override
  public List<TimeWindow> getTime_windows() {
    return time_windows;
  }

  @Override
  public void setTime_windows(List<TimeWindow> time_windows) {
    this.time_windows = time_windows;
  }

  //  public DynamicCustomer(int id, int demand, int duration) {
//    super(id, demand, duration);
//  }
}
