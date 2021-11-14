import java.util.List;

public class StaticCustomer extends Customer{
//  public StaticCustomer(int id, int demand, int duration) {
//    super(id, demand, duration);
//  }

    Coordinaat coords;
    int demand;
    int dur;
    List<Integer> fixed_pattern;
    int id;
    List<TimeWindow> time_windows;
}
