import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Main {
  public static void main(String[] args){
    try {
      Input input = JsonReader.inlezen();
      System.out.println(input);



      //Creeeren van array met set customers to server
      Set<Customer>[] daysWithCustToServe = new Set[input.getNum_periods()];
      for (int i=0 ; i<daysWithCustToServe.length;i++) {
        daysWithCustToServe[i] = new HashSet<>();
      }

      //TOEVOEGEN VAN DYNAMISCHE KLANTEN AAN DAG
      for (DynamicCustomer dc : input.getDynamic_customers()) {
        //TOEVOEGEN EERSTE BEZOEK
        daysWithCustToServe[dc.getDyn_fvisit()].add(dc);

        //TOEVOEGEN ANDERE BEZOEKEN(MAX AANTAL OPEENVOLGENDE DAGEN GEBRUIKEN)
        //CHECK OF KLANT OPEN IS DIE DAG
        for (int i = dc.getDyn_fvisit(); i<input.getNum_periods();i=i+dc.getDyn_nvisit()+1) {
            while (dc.getTime_windows().get(i).late==0) {
              i--;
            }
            daysWithCustToServe[i].add(dc);

            }
          }





      //TOEVOEGEN VAN STATISCHD KLANTEN AAN DAG(VIA PARAMETERS)
      for (StaticCustomer sc : input.getFixed_customers()) {
        for (int i = 0 ; i <sc.getFixed_pattern().size();i++) {
          daysWithCustToServe[sc.getFixed_pattern().get(i)].add(sc);
        }
      }

      Scheduler scheduler = new Scheduler(input);
      List<Day> schedule = new LinkedList<>();

    for (int i = 0 ;i<input.getNum_periods();i++) {
      Day day = scheduler.scheduleDay(i,daysWithCustToServe[i]);
      schedule.add(day);
    }




    } catch (IOException e) {
      e.printStackTrace();
    }







  }
}
