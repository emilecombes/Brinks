package Output;

import Model.Location;

import java.util.List;

public class OutputRoute {
   int departure_time;
   int[] visits;
   int duration;

    public OutputRoute(int departure_time, List<Location> visites, int duration) {
        this.departure_time = departure_time;
        this.visits = new int[visites.size()-1];
        for (int i = 0 ; i< visits.length;i++) {
            visits[i] = visites.get(i).getId();
        }
        this.duration=duration;
    }

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

    public int[] getVisits() {
        return visits;
    }

    public void setVisits(int[] visits) {
        this.visits = visits;
    }
}
