package n3b_pr4;

public class N3B_PR4 {

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 11, 6}, {7, 8, 9}};
        int[][] mat2 = {{1, 2, 3, 6, 7}, 
                        {1, 2, 7, 6, 9}, 
                        {1, 2, 3, 2, 1}, //Esta es la simétrica
                        {0, 2, 3, 3, 7},
                        {4, 5, 3, 5, 4}}; // Esta también es simétrica
        //        mostrarDiagonalV1(mat);
        //        System.out.println("");
        //        mostrarDiagonalV2(mat);
        //        System.out.println("Maximo valor: " + maximoMatriz(mat));
        //        mostrarColumna(mat, 1);
        //        mostrarFilasImparesV1(mat);
        // mostrarFilasImparesV2(mat);
        // System.out.println(esPalindroma(mat2));
        mostrarSumaCol(mat2);
    }

    public static void mostrarMatriz(int[][] mat) {
        int largoMat = mat.length;
        for (int i = 0; i < largoMat; i++) {
            int largoMatEni = mat[i].length;
            for (int j = 0; j < largoMatEni; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void mostrarDiagonalV1(int[][] mat) {
        for (int fila = 0; fila < mat.length; fila++) {
            for (int col = 0; col < mat[fila].length; col++) {
                if (fila == col) {
                    System.out.print(mat[fila][col] + " ");
                }
            }
        }
    }

    public static void mostrarDiagonalV2(int[][] mat) {
        for (int pos = 0; pos < mat.length; pos++) {
            System.out.print(mat[pos][pos] + " ");
        }
    }

    public static int maximoMatriz(int[][] mat) {
        int max = mat[0][0]; //Integer.MIN_VALUE;

        for (int fila = 0; fila < mat.length; fila++) {

            for (int col = 0; col < mat[fila].length; col++) {
                if (mat[fila][col] > max) {
                    max = mat[fila][col];
                }
            }
        }
        return max;
    }

    public static void mostrarColumna(int[][] mat, int columna) {
        for (int fila = 0; fila < mat.length; fila++) {
            System.out.println(mat[fila][columna]);
        }
    }

    public static void mostrarFila(int[][] mat, int fila) {
        for (int columna = 0; columna < mat[fila].length; columna++) {
            System.out.println(mat[fila][columna]);
        }
    }

    public static void mostrarFilasImparesV1(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            if (i % 2 != 0) {
                for (int j = 0; j < mat[i].length; j++) {
                    System.out.print(mat[i][j] + " ");
                }
                System.out.println("");
            }

        }
    }

    public static void mostrarFilasImparesV2(int[][] mat) {
        for (int i = 1; i < mat.length; i += 2) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
    public static boolean esSimetrico(int v[]) {

        boolean es = true;

        for (int i = 0; i < v.length / 2 && es; i++) {
            if (v[i] != v[v.length - 1 - i]) {
                es = false;
            }
        }

        return es;

    }
    
    public static int esPalindroma (int[][] mat){
        
        for (int i = 0; i < mat.length; i++) {
            if(esSimetrico(mat[i])){
                return i;
            }
        }
        
        return -1;
    }
    
     public static void mostrarSumaCol(int[][] mat){
         for (int j = 0; j < mat[0].length; j++) {
             for (int i = 0; i < mat.length; i++) {
                 System.out.print(mat[i][j] + " + ");
             }
             System.out.println("");
         }
     }
}
