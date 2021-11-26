package Model;

import java.util.List;

public class Location {

    Coordinate coords;
    int id;
    List<TimeWindow> time_windows;

    public Coordinate getCoords() {
        return coords;
    }

    public void setCoords(Coordinate coords) {
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

    public int getStartTimeAfter(int arrive){
        // No wait times
        for(TimeWindow tw : time_windows){
            if (tw.getEarly() <= arrive && tw.getLate() > arrive) return arrive;
        }

        // Wait until next window
        int start = Integer.MAX_VALUE;
        for(TimeWindow tw : time_windows){
            if(tw.getEarly() < start && tw.getLate() > arrive) start = tw.getEarly();
        }
        return start;
    }

    @Override
    public String toString() {
        return "Model.Location{" +
                "coords=" + coords +
                ", id=" + id +
                '}';
    }
}
