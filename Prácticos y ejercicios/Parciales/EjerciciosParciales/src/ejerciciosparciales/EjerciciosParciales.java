package ejerciciosparciales;

import tads.ListaNodos;
import tads.NodoLista;

public class EjerciciosParciales {

    public static void main(String[] args) {
        int[][] mat = {{10, 1, 34, 34, 22},
        {34, 5, 7, 7, 7},
        {6, 5, 45, 3, 4},
        {45, 8, 45, 45, 0},
        {44, 66, 66, 66, 8},
        {78, 9, 0, 32, 11}};

        //System.out.println("Esta valor: " + estaValor(mat, 2, 9));
        //System.out.println("Existe fila: " + existeFila(mat));
        
        ListaNodos lista = new ListaNodos();
        lista.agregarFinal(1);
        lista.agregarFinal(8);
        lista.agregarFinal(2);
        lista.agregarFinal(32);
        lista.agregarFinal(23);
        lista.agregarFinal(10);
        
        System.out.println("Suma valores rec: " + sumaValores(lista.lista, 10));
    }

    // Parcial 09/12/2024, ejercicio 1.a
    public static boolean estaValor(int[][] mat, int col, int val) {

        if (mat.length == 0 || col < 0 || col >= mat[0].length) {
            return false;
        }

        for (int i = 0; i < mat.length; i++) {
            if (mat[i][col] == val) {
                return true;
            }
        }
        return false;
    }

    // Parcial 09/12/2024, ejercicio 1.b
    public static boolean existeFila(int[][] mat) {
        if (mat.length == 0) {
            return false;
        }

        for (int fila = 0; fila < mat.length; fila++) {
            int cant = 1;
            for (int col = 0; col < mat[fila].length - 1 && cant < 3; col++) {
                if (mat[fila][col] == mat[fila][col + 1]) {
                    cant++;
                } else {
                    cant = 1;
                }
            }
            if (cant == 3) {
                return true;
            }
        }

        return false;
    }

    // Parcial 09/12/2024, ejercicio 2.a
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int actual = arr[i];
            int j = i - 1; // "int j = i" Acá debería ser i - 1 porque debo 
                           // posicionarme en el índice anterior
            // "while (j > 0 && arr[j] < arr[j - 1])" porque en el primer caso
            // j ya valdría 0 y nunca entraría al while. Además, al hacer "j >= 0"
            // dentro no puede haber un "j - 1" porque se va de rango, entonces
            // debería actualizar siempre el siguiente (j+1) con respecto a donde
            // estoy parado (j).
            while (j >= 0 && arr[j] < actual) {
                arr[j + 1] = arr[j];
                j--;
            }
            // "arr[i]" Lo cambio por "j+1" porque i es la posición donde ya
            // estaba el elemento actual originalmente, no tiene sentido.
            arr[j + 1] = actual;
        }
    }

    // Parcial 09/12/2024, ejercicio 2.b
    // [34,11,5,1,3,90] (original)
    // [11,34,5,1,3,90] (pasada 1)
    // [5,11,34,1,3,90] (pasada 2)
    // [1,5,11,34,3,90] (pasada 3)
    // [1,3,5,11,34,90] (pasada 4)
    // [1,3,5,11,34,90] (pasada 5)
    
    public static int sumaValores(NodoLista inicio, int n){
        if(inicio == null) return 0; // Caso base
        if((int)inicio.getDato() > n){
            return (int)inicio.getDato() + sumaValores(inicio.getSiguiente(), n);
        }else{
            return sumaValores(inicio.getSiguiente(), n);
        }
    }
}
