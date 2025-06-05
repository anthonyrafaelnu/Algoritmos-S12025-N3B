package Prueba;

public class Prueba {
    
    public static void main(String[] args){
//        Prueba p = new Prueba();
//        
//        int resultado = p.sumarDos(4, 3);
//        System.out.println("Resultado: " + resultado);
//        
//        System.out.println("Resultado static: " + sumaDeADos(2,3));

        //ej2(4,15);
        
        ej4(1523);
    }
    
    public static void imprimirImpares(){
        for (int i = 1; i <= 50; i++) {
            if(i%2 != 0){
                System.out.print(i + " - ");
            }
        }
    }
    
    public static void imprimirImpares2(){
        for (int i = 1; i <= 49; i+=2) {
            System.out.print(i + " - ");
        }
    }
    
    public int sumarDos(int num1, int num2){
        return num1 + num2;
    }
    
    public static int sumaDeADos(int num1, int num2){
        return num1 + num2;
    }
    
    public static void ej2(int num1, int num2){
        System.out.println("Promedio = " + promedio(num1, num2));
        System.out.println("Cantidad de pares = " + cantNumerosParesEntre(num1, num2));
    }
    
    public static int cantNumerosParesEntre(int num1, int num2){
        int minimo = Math.min(num1, num2);
        int maximo = Math.max(num1, num2);
        
        int contadorDePares = 0;
        
        for (int i = minimo; i <= maximo; i++) {
            if(i%2 == 0){
                contadorDePares++;
            }
        }
        
        return contadorDePares;
    }
    
    public static double promedio(int num1, int num2){
        double resultado = (num1 + num2) / 2.0;
        
        return resultado;
    }
    
    public static void ej3(int n){
        for (int i = 1; i <= n; i+=2) {
            System.out.print(i + " ");
        }
    }
    
    public static void ej3_2(int n){
        int i = 1;
        while(i <= n){
            System.out.print(i + " ");
            i+=2;
        }
    }
    
    public static void ej4(int num){
        
        String numString = num + "";
        String numSeparado = "";
        
        for (int i = numString.length(); i >= 1; i--) {
            int ultimoNumero = num%10;
            num /= 10;
            
            numSeparado += ultimoNumero + " ";
        }
        
        
        System.out.println(numSeparado);
        
    }
    
}
