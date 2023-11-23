import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*Generalizamos la libreria util para evitar renglones*/

public class Scanner {

  private final String source;

  private final List<Token> tokens = new ArrayList<>();

  private static final Map<String, TipoToken> palabrasReservadas;
  static {
    palabrasReservadas = new HashMap<>();
    palabrasReservadas.put("select", TipoToken.SELECT);
    palabrasReservadas.put("from", TipoToken.FROM);
    palabrasReservadas.put("distinct", TipoToken.DISTINCT);
  }

  public Scanner(String source) {
    this.source = source + " ";
  }

  public List<Token> scanTokens() throws Exception{
    int estado = 0;
    char c = 0;
    String lexema = "";
    int inLex = 0;

}
