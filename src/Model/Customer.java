package Model;

import java.util.List;

public class Customer extends Location {

    int demand;
    int duration;

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

    public Coordinaat getCoords() {
        return coords;
    }

    public void setCoords(Coordinaat coords) {
        this.coords = coords;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<TimeWindow> getTime_windows() {
        return time_windows;
    }

    public void setTime_windows(List<TimeWindow> time_windows) {
        this.time_windows = time_windows;
    }
}
