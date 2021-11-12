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
}
