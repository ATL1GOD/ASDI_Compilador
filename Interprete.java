import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Interprete{
  static boolean Errores=false;

  public static void main (String[] args) throws IOException{
    ejecutarPrompt();
  }

  private static void ejecutarPrompt() throws IOException{
    InputStreamReader input = new InputStreamReader(System.in);
    BufferedReader reader = new BufferedReader(input);
      for(;;){
        System.out.print(">>>");
        String linea =reader.readLine();
        if(linea==null){ /*Corrobar si el break jala de esta manera, sin las llaves*/
          break;
          ejecutar(linea);
          Errores=false;
        }
      }
  }

  private static void main ejecutar (String source){
    Scanner scanner = new Scanner(source);
    /* Modificar esta parte para agregar los nuevos elementos del parser y el ASDI*/
  }
}
