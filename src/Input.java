import java.util.List;

public class Input {
    int capacity;
    float cost_fuel_minute, cost_wage_minute;
    List<Depot> depots;
    List<DynamicCustomer> dynamic_customers;
    List<StaticCustomer> fixed_customers;
    String instance_name;
    int max_route_dur;
    int num_periods;
    List<List<Integer>> times;

    public Input(int capacity, float cost_fuel_minute, float cost_wage_minute, List<Depot> depots, List<DynamicCustomer> dynamic_customers, List<StaticCustomer> fixed_customers, String instance_name, int max_route_dur, int num_periods, List<List<Integer>> times) {
        this.capacity = capacity;
        this.cost_fuel_minute = cost_fuel_minute;
        this.cost_wage_minute = cost_wage_minute;
        this.depots = depots;
        this.dynamic_customers = dynamic_customers;
        this.fixed_customers = fixed_customers;
        this.instance_name = instance_name;
        this.max_route_dur = max_route_dur;
        this.num_periods = num_periods;
        this.times = times;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public float getCost_fuel_minute() {
        return cost_fuel_minute;
    }

    public void setCost_fuel_minute(float cost_fuel_minute) {
        this.cost_fuel_minute = cost_fuel_minute;
    }

    public float getCost_wage_minute() {
        return cost_wage_minute;
    }

    public void setCost_wage_minute(float cost_wage_minute) {
        this.cost_wage_minute = cost_wage_minute;
    }

    public List<Depot> getDepots() {
        return depots;
    }

    public void setDepots(List<Depot> depots) {
        this.depots = depots;
    }

    public List<DynamicCustomer> getDynamic_customers() {
        return dynamic_customers;
    }

    public void setDynamic_customers(List<DynamicCustomer> dynamic_customers) {
        this.dynamic_customers = dynamic_customers;
    }

    public List<StaticCustomer> getFixed_customers() {
        return fixed_customers;
    }

    public void setFixed_customers(List<StaticCustomer> fixed_customers) {
        this.fixed_customers = fixed_customers;
    }

    public String getInstance_name() {
        return instance_name;
    }

    public void setInstance_name(String instance_name) {
        this.instance_name = instance_name;
    }

    public int getMax_route_dur() {
        return max_route_dur;
    }

    public void setMax_route_dur(int max_route_dur) {
        this.max_route_dur = max_route_dur;
    }

    public int getNum_periods() {
        return num_periods;
    }

    public void setNum_periods(int num_periods) {
        this.num_periods = num_periods;
    }

    public List<List<Integer>> getTimes() {
        return times;
    }

    public void setTimes(List<List<Integer>> times) {
        this.times = times;
    }
}
