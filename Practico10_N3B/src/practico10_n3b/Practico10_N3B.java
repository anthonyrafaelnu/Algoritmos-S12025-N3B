package practico10_n3b;


public class Practico10_N3B {

    public static void main(String[] args) {
        //System.out.println(fib(6));
        //System.out.println(factorial(3));
        //System.out.println(invertir("Hola"));
        System.out.println(invertirV2("Hola"));
    }
    public static int factorial(int n){
        if(n == 0) return 1;
        return n * factorial(n-1);
    }
    
    public static int fib(int n){
        int[] datos = new int[n+1];
        return fibRec(n, datos);
    }
    public static int fibRec(int n, int[] datos){
        // Caso base
        if(n == 0 || n == 1) return n;
        
        // Ya calculado para esa posición (no recalcular)
        if(datos[n] != 0) return datos[n];
        
        // Todavía no calculado, hacer cuentas
        datos[n] = fibRec(n-1, datos) + fibRec(n-2, datos);
        return datos[n];
    }
    
    public static String invertir(String palabra){
        if(palabra.length() == 1) return palabra;
        return invertir(palabra.substring(1)) + 
                palabra.charAt(0);
    }
    
    public static String invertirV2(String palabra){
        return invertirv2Rec(palabra, palabra.length() - 1);
    }
    
    public static String invertirv2Rec(String palabra, int pos){
        if(pos == 0) return palabra.charAt(pos) + "";
        return palabra.charAt(pos) + 
                invertirv2Rec(palabra, pos - 1);
    }
    
    public static int max(int[] v){
        return maxRec(v, 0);
    }
    
    public static int maxRec(int[] v, int pos){
        if(v.length - 1 == pos) return v[pos];
        int maxRet = maxRec(v, pos+1);
        if(maxRet > v[pos]){
            return maxRet;
        }else{
            return v[pos];
        }
    }
    
}
