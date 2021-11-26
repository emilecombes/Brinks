package Output;

import Model.Route;

import java.util.LinkedList;
import java.util.List;

public class OutputPeriod {
    int id;
    List<OutputRoute> routes;

    public void addRoutes(List<Route> routesold) {
        for (Route r : routesold) {
            OutputRoute outputRoute = new OutputRoute(r.getDeparture_time(),r.getVisits(),r.getDuration());
            routes.add(outputRoute);
        }

    }

    public OutputPeriod(int id) {
        this.id = id;
        routes = new LinkedList<>();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<OutputRoute> getRoutes() {
        return routes;
    }

    public void setRoutes(List<OutputRoute> routes) {
        this.routes = routes;
    }
}
