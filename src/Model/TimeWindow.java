package Model;

public class TimeWindow {
    private int early, late;

    public TimeWindow(int early, int late) {
        this.early = early;
        this.late = late;
    }

    public int getEarly() {
        return early;
    }

    public void setEarly(int early) {
        this.early = early;
    }

    public int getLate() {
        return late;
    }

    public void setLate(int late) {
        this.late = late;
    }
}
