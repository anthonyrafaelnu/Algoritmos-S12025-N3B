package n3b_pr3;

public class N3B_PR3 {

    public static void main(String[] args) {

        int[] lista = {3, 5, 8, 13, 19};
        //System.out.println(ej1mostrarVec(lista));
        System.out.println(ej8ExisteElementoV2(lista,15));
    }

    public static String ej1mostrarVec(int v[]) {

        String retorno = "";

        for (int i = 0; i < v.length; i++) {

            if (i == v.length - 1) {
                retorno = retorno + v[i];
            } else {
                retorno = retorno + v[i] + " - ";
            }

        }

        return retorno;
    }

    public static double ej2Promedio(int v[]) {

        double suma = 0;

        for (int i = 0; i < v.length; i++) {
            suma += v[i];
        }

        return suma / v.length;

    }

    public static String ej2ValoresImpares(int v[]) {

        String cadena = "";

        for (int i = 0; i < v.length; i++) {
            if (v[i] % 2 != 0) {
                cadena += v[i] + " ";
            }
        }

        return cadena;
    }

    /*
        PRE: Recibe un vector no vacío y no ordenado, de enteros
        POS: Retorna el valor máximo del vector
     */
    public static int maxVectorV1(int v[]) {
        int max = Integer.MIN_VALUE;
        //int max = v[0];

        for (int i = 0; i < v.length; i++) {
            if (v[i] > max) {
                max = v[i];
            }
        }
        return max;
    }

    /*
        PRE: Recibe un vector no vacío y está ordenado en forma asc, de enteros
        POS: Retorna el valor máximo del vector
     */
    public static int maxVectorV2(int v[]) {
        return v[v.length - 1];
    }

    /*
        PRE: v es una vector no vacío de enteros, no ordenado
        POS: Retorna un boolean indicando si el array es simétrico
     */
    public static boolean esSimetrico(int v[]) {

        boolean es = true;

        for (int i = 0; i < v.length / 2 && es; i++) {
            if (v[i] != v[v.length - 1 - i]) {
                es = false;
            }
        }

        return es;

    }

    /*
    PRE: desde y hasta >=0
         desde y hasta < largo del vector
         desde <= hasta
         v es un vector no vacio, desordenado de enteros
    POS: Retorna la posción del mínimo valor del vector, entre desde y hasta inclusive
     */
    public static int ej7posMinVec(int v[], int desde, int hasta) {

        int posMin = desde;

        for (int i = desde; i <= hasta; i++) {
            if (v[i] < v[posMin]) {
                posMin = i;
            }
        }

        return posMin;

    }

    /*
        PRE: v es un vector desordenado de enteros, no vacío
             y número es un valor entero
        POS: Retorna un boolean indicando si existe número en el array
     */
    public static boolean ej8ExisteElementoV1(int v[], int numero) {

        boolean esta = false;

        for (int i = 0; i < v.length && !esta; i++) {
            if (v[i] == numero) {
                esta = true;
            }
        }
        return esta;
    }

    /*
        PRE: v es un vector ordeando de enteros, no vacío
             y número es un valor entero
        POS: retorna un boolean indicando si existe número en el array
     */
    public static boolean ej8ExisteElementoV2(int v[], int numero) {

        boolean esta = false;

        for (int i = 0; i < v.length && !esta && numero >= v[i]; i++) {
            if (v[i] == numero) {
                esta = true;
            }
        }
        return esta;

    }
    
    
     /*
        PRE: v es un vector ordeando de enteros, no vacío
             y número es un valor entero
        POS: retorna un boolean indicando si existe número en el array
     */
    public static boolean ej8ExisteElementoBiparticion(int v[], int numero) {

        int ini = 0;
        int fin = v.length-1;
        boolean encontre = false;

        while(ini<=fin && !encontre){
            
            int medio = (ini + fin)/2;
            if(v[medio] == numero){
                encontre = true;
            }
            else{
                if(numero < v[medio]){
                    fin = medio - 1;
                }
                else{
                    ini = medio +1;
                }
            }
        }
        return encontre;

    }
    
}
