import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Interprete {

  static boolean existenErrores = false;

  public static void main(String[] args) throws IOException {
    if (args.length > 1) {
      System.out.println("Uso correcto: Interprete [archivo.txt]");
      // condicional para error en el archivo de texto, nos ayudara a identificar como
      // inicia el programa
      // Convención definida en el archivo "system.h" de UNIX
      System.exit(64); // status (palabra por defecto):64
    } else if (args.length == 1) {
      ejecutarArchivo(args[0]);
    } else {
      ejecutarPrompt();
    }
  }

  private static void ejecutarArchivo(String path) throws IOException {
    byte[] bytes = Files.readAllBytes(Paths.get(path));
    ejecutar(new String(bytes, Charset.defaultCharset()));
    // Se indica que existe un error
    if (existenErrores)
      System.exit(65); // status (palabra por defecto):65
  }

  private static void ejecutarPrompt() throws IOException {
    InputStreamReader input = new InputStreamReader(System.in);
    BufferedReader reader = new BufferedReader(input);
    for (;;) {
      System.out.print(">>>");
      String linea = reader.readLine();
      if (linea == null) /* Corrobar si el break jala de esta manera, sin las llaves */
        break;
      ejecutar(linea);
      existenErrores = false;
    }
  }

  private static void ejecutar(String source) {
    Scanner scanner = new Scanner(source);
    /*
     * Modificar esta parte para agregar los nuevos elementos del parser y el ASDI
     */
  }
}
