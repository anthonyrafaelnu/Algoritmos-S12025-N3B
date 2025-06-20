package ejerciciosparciales;

public class EjerciciosParciales {

    public static void main(String[] args) {
        int[][] mat = {{10, 1, 34, 34, 22}, 
                       {34, 5, 7, 7, 7},
                       {6, 5, 45, 3, 4}, 
                       {45, 8, 45, 45, 0}, 
                       {44, 66, 66, 66, 8},
                       {78, 9, 0, 32, 11}};
        
        //System.out.println("Esta: " + estaValor(mat, 2, 9));
    }
    
    // Parcial 09/12/2024, ejercicio 1.a
    public static boolean estaValor(int[][] mat, int col, int val){
        
        if(mat.length == 0 || col < 0 || col >= mat[0].length) return false;
        
        for (int i = 0; i < mat.length; i++) {
            if(mat[i][col] == val) return true;
        }
        return false;
    }
    
}
