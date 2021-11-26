package Model;

import java.util.List;

public class StaticCustomer extends Customer {
    List<Integer> fixed_pattern;

    public StaticCustomer(Coordinate coords, int demand, int dur, List<Integer> fixed_pattern, int id, List<TimeWindow> time_windows) {
        this.coords = coords;
        this.demand = demand;
        this.duration = dur;
        this.fixed_pattern = fixed_pattern;
        this.id = id;
        this.time_windows = time_windows;
    }

    @Override
    public Coordinate getCoords() {
        return coords;
    }

    @Override
    public void setCoords(Coordinate coords) {
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

    public List<Integer> getFixed_pattern() {
        return fixed_pattern;
    }

    public void setFixed_pattern(List<Integer> fixed_pattern) {
        this.fixed_pattern = fixed_pattern;
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
