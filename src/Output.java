import java.util.List;

public class Output {
    String instance_name;
    float cost;
    List<Day> periods;


    public Output(String instance_name, float cost, List<Day> periods) {
        this.instance_name = instance_name;
        this.cost = cost;
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

    public List<Day> getPeriods() {
        return periods;
    }

    public void setPeriods(List<Day> periods) {
        this.periods = periods;
    }
}
