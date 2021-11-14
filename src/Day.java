import java.util.LinkedList;
import java.util.List;

public class Day {
    int id;
    List<Route> routes;


    public Day(int id){
        routes = new LinkedList<>();
        this.id= id;


    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void addRoutes (List<Route> newroutes) {
        for (Route r : newroutes ) {
            routes.add(r);
        }
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }
}
