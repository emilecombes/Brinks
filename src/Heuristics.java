import java.util.List;
import java.util.Random;

public class Heuristics {
    private List<Day> days;
    private Random random = new Random();

    public Heuristics (List<Day> days) {
        this.days=days;
    }

    public void moveCustomerWithinDay(){
        int d = random.nextInt(days.size());
        Day day = days.get(d);
        int r = random.nextInt(day.getRoutes().size());
        Route route = day.getRoutes().get(r);
        int c = random.nextInt(route.getVisits().size());
        Customer customer = (Customer) route.getVisits().get(c);
    }

    public void constructNewRoute(){

    }
}
