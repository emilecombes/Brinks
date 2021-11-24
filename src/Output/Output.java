package Output;

import Model.Day;

import java.util.LinkedList;
import java.util.List;

public class Output {
    String instance_name;
    float cost;
    List<OutputPeriod> periods;

    public Output(String instance_name, float cost) {
        this.instance_name = instance_name;
        this.cost = cost;
    }


    public void parseForOutput(List<Day> schedule) {
        periods = new LinkedList<>();
        for (Day day : schedule) {
            OutputPeriod period = new OutputPeriod(day.getId());
            period.addRoutes(day.getRoutes());
            periods.add(period);
        }
    }

    public List<OutputPeriod> getPeriods() {
        return periods;
    }

    public void setPeriods(List<OutputPeriod> periods) {
        this.periods = periods;
    }

    public String getInstance_name() {
        return instance_name;
    }

    public void setInstance_name(String instance_name) {
        this.instance_name = instance_name;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }


}
