package Input;

import Model.*;

import java.util.List;

public class Input {
    public int capacity;
    public float cost_fuel_minute, cost_wage_minute;
    public List<Depot> depots;
    public List<DynamicCustomer> dynamic_customers;
    public List<StaticCustomer> fixed_customers;
    public String instance_name;
    public int max_route_dur;
    public int num_periods;
    public List<List<Integer>> times;


    public int getCapacity() {
        return capacity;
    }

    public float getCost_fuel_minute() {
        return cost_fuel_minute;
    }

    public float getCost_wage_minute() {
        return cost_wage_minute;
    }

    public List<Depot> getDepots() {
        return depots;
    }

    public List<DynamicCustomer> getDynamic_customers() {
        return dynamic_customers;
    }

    public List<StaticCustomer> getFixed_customers() {
        return fixed_customers;
    }

    public String getInstance_name() {
        return instance_name;
    }

    public int getMax_route_dur() {
        return max_route_dur;
    }

    public int getNum_periods() {
        return num_periods;
    }

    public List<List<Integer>> getTimes() {
        return times;
    }
}
