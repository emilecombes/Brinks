package Model;

import java.util.List;

public class DynamicCustomer extends Customer {
    int dyn_fvisit;
    int dyn_nvisit;

    public DynamicCustomer(Coordinaat coords, int demand, int dur, int id, List<TimeWindow> time_windows) {
        super();
        this.coords = coords;
        this.demand = demand;
        this.duration = dur;
        this.id = id;
        this.time_windows = time_windows;
    }

  public int getDyn_fvisit() {
    return dyn_fvisit;
  }

  public void setDyn_fvisit(int dyn_fvisit) {
    this.dyn_fvisit = dyn_fvisit;
  }

  public int getDyn_nvisit() {
    return dyn_nvisit;
  }

  public void setDyn_nvisit(int dyn_nvisit) {
    this.dyn_nvisit = dyn_nvisit;
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
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
}
