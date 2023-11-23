import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ASDI {

    private boolean Errores = false; // 0 , 1 false =0
    private final List<Token> tokens; /*
                                       * Una lista de tokens que se pasa al constructor, los tokens se
                                       * ya debieron ser procesados antes para mandar a llamar la lista unicamente
                                       ***********************
                                       * ------------Token 0 *
                                       * ------------Token 1 *
                                       * ------------Token 2 *
                                       ***********************/
    ArrayList<String> tablaArrayList = new ArrayList<>(); /*
                                                           * Una lista de cadenas que se utiliza
                                                           * para almacenar las cadenas
                                                           */
    String tabla, strPila, strLex; /* Cadenas que guardan informacion y tokens */
    Token A; // Objeto tipo Token para guardar elementos del token
    Stack<String> pila = new Stack<>(); // una pila
    /*
     * ------------------Plato 2
     * ------------------Plato 1
     * ------------------Plato 0
     */

    public ASDI(List<Token> tokens) {
        this.tokens = tokens; /* Constructor para la lista de tokens */
    }

    public boolean parse() {
        String[][] tabla = {
                { "", "select", "from", "distinct", "*", ",", "id", ".", "$" },
                { "Q", "Q -> select D from T", "", "", "", "", "", "", "" },
                { "D", "", "", "D -> distinct P", "D -> P", "", "D -> P", "", "" },
                { "P", "", "", "", "P -> *", "", "P -> A", "", "" },
                { "A", "", "", "", "", "", "A -> A2 A1", "", "" },
                { "A1", "", "A1 -> E", "", "", "A1 -> , A", "", "", "" },
                { "A2", "", "", "", "", "", "A2 -> id A3", "", "" },
                { "A3", "", "A3 -> E", "", "", "A3 -> E", "", "A3 -> . id", "" },
                { "T", "", "", "", "", "", "T -> T2 T1", "", "" },
                { "T1", "", "", "", "", "T1 -> , T", "", "", "T1 -> E" },
                { "T2", "", "", "", "", "", "T2 -> id T3", "", "" },
                { "T3", "", "", "", "", "T3 -> E", "T3 -> id", "", "T3 -> E" }
        };
    }
}
