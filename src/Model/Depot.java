package Model;

import java.util.List;

public class Depot extends Customer {


    public Depot(Coordinate coords, int id, List<TimeWindow> time_windows) {
        this.coords = coords;
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
