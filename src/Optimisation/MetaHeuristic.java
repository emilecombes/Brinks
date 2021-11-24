package Optimisation;

import Model.Day;
import Optimisation.Heuristics;

public class MetaHeuristic {
    int temperatuur;
    Day solution;
    Heuristics heuristics;


    public MetaHeuristic(int startTemperatuur, Day day, Heuristics heuristics) {
        this.temperatuur= startTemperatuur;
        this.solution=day;
        this.heuristics=heuristics;
    }

    public Day simulatedAnnealing(long seconds) {
        long miliseconds = System.currentTimeMillis();
        long duration = seconds*1000;
        long endTime = miliseconds+duration;
        while (!(System.currentTimeMillis() ==endTime)) {
            Day oldDay = heuristics.getDay();
            heuristics.moveCustomer();
            long deltaE= heuristics.getDay().getCost()-oldDay.getCost();
            if (deltaE<=0) {
                System.out.println("There was an improvement so we left the schedule");
            } else {
                if (probability(deltaE,temperatuur)) {
                    System.out.println("We accepted the worse solution because of the probability ");
                } else {
                    heuristics.setDay(oldDay);
                }
            }
            temperatuur=calculateNewTemp(deltaE,temperatuur);
        }
    }


    public calculateNewTemp(int deltaE, int oldTemp) {
        int newTemp;
    }


    public probability(int deltaE,int temp) {

    }
}
