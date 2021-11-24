package Optimisation;

import Model.*;

import java.util.List;

public class GlobalModifier {
  private static List<List<Integer>> travelTimes;
  private List<Day> days;

  public GlobalModifier(List<List<Integer>> t, List<Day> d){
    travelTimes = t;
    days = d;
  }

  public static int getTravelTime(Location from, Location to){
    return travelTimes.get(from.getId()).get(to.getId());
  }
}
