package Model;

import java.util.LinkedList;
import java.util.List;

public class Day {
    int id;
    List<Route> routes;
    long cost;


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



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }
}
