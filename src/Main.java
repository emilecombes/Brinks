import java.io.IOException;

public class Main {
  public static void main(String[] args){
    try {
      Input input = JsonReader.inlezen();
      System.out.println(input);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
