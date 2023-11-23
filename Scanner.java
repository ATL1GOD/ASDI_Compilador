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

  public List<Token> scanTokens() throws Exception {
    int estado = 0;
    char c = 0;
    String lexema = "";
    int inLex = 0;

    for (int i = 0; i < source.length(); i++) {
      c= source.charAt(i);

      switch (estado) {
        case 0:
          if (c == '*') {
            tokens.add(new Token(TipoToken.ASTERISCO, "*", i + 1));
          } else if (c == ',') {
            tokens.add(new Token(TipoToken.COMA, ",", i + 1));
          } else if (c == '.') {
            tokens.add(new Token(TipoToken.PUNTO, ".", i + 1));
          } else if (Character.isAlphabetic(c)) {
            estado = 1;
            lexema = lexema + c;
            inLex = i;
          }
          break;

        case 1:
          if (Character.isAlphabetic(c) || Character.isDigit(c)) {
            lexema = lexema + c;
          } else {
            TipoToken tt = palabrasReservadas.get(lexema);
            if (tt == null) {
              tokens.add(new Token(TipoToken.IDENTIFICADOR, lexema, inLex + 1));
            } else {
              tokens.add(new Token(tt, lexema, inLex + 1));
            }

            estado = 0;
            i--;
            lexema = "";
            inLex = 0;
          }
          break;
      }
    }
    tokens.add(new Token(TipoToken.EOF, "$", source.length()));

    return tokens;
  }
}
