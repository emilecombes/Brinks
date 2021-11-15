import java.util.List;

public class Location {

    Coordinaat coords;
    int id;
    List<TimeWindow> time_windows;

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
