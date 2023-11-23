public class Analisis {
    // Método para ver si M[X, a] = X
    public static String validar(String stringX, String stringA, String[][] tabla) {
        int fila = 0;
        int columna = 0;
        for (int i = 0; i < tabla.length; i++) {
            if (tabla[i][0].hashCode() == stringX.hashCode()) {
                fila = i;
                break;
            }
        }
    }
}