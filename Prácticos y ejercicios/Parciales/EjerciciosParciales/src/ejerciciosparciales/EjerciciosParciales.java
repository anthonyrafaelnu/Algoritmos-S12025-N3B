package ejerciciosparciales;

public class EjerciciosParciales {

    public static void main(String[] args) {
        int[][] mat = {{10, 1, 34, 34, 22}, 
                       {34, 5, 7, 7, 7},
                       {6, 5, 45, 3, 4}, 
                       {45, 8, 45, 45, 0}, 
                       {44, 66, 66, 66, 8},
                       {78, 9, 0, 32, 11}};
        
        //System.out.println("Esta valor: " + estaValor(mat, 2, 9));
        System.out.println("Existe fila: " + existeFila(mat));
    }
    
    // Parcial 09/12/2024, ejercicio 1.a
    public static boolean estaValor(int[][] mat, int col, int val){
        
        if(mat.length == 0 || col < 0 || col >= mat[0].length) return false;
        
        for (int i = 0; i < mat.length; i++) {
            if(mat[i][col] == val) return true;
        }
        return false;
    }
    
    // Parcial 09/12/2024, ejercicio 1.b
    public static boolean existeFila(int[][] mat){
        if(mat.length == 0) return false;
        
        for (int fila = 0; fila < mat.length; fila++) {
            int cant = 1;
            for (int col = 0; col < mat[fila].length - 1 && cant < 3; col++) {
                if(mat[fila][col] == mat[fila][col+1]){
                    cant++;
                }else{
                    cant = 1;
                }
            }
            if(cant == 3) return true;
        }
        
        return false;
    }
    
}
