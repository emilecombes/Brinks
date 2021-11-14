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
      Set<Customer>[] daysWithCustToServe = new Set[input.getDynamic_customers().get(0).getTime_windows().size()];
      for (int i=0 ; i<daysWithCustToServe.length-1;i++) {
        daysWithCustToServe[i] = new HashSet<>();
      }

      //TOEVOEGEN VAN DYNAMISCHE KLANTEN AAN DAG(MAX AANTAL OPEENVOLGENDE DAGEN GEBRUIKEN)
      for (DynamicCustomer dc : input.getDynamic_customers()) {
        //daysWithCustToServe[]
      }



      //TOEVOEGEN VAN STATISCHD KLANTEN AAN DAG(VIA PARAMETERS)





    } catch (IOException e) {
      e.printStackTrace();
    }







  }
}
