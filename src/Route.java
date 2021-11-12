import java.util.LinkedList;
import java.util.List;

public class Route {
  private List<Customer> route;
  private int startTime;
  private int endTime;

  public Route(){
    route = new LinkedList<>();
  }

  public void addCustomer(Customer c){
    route.add(c);
  }

  public boolean isFeasibleWith(Customer c){
    return false;
  }
}
