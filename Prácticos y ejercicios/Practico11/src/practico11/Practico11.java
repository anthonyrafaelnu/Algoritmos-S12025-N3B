package practico11;

public class Practico11 {

    public static void main(String[] args) {
        Lista l = new Lista();
        l.agregarFinal(2);
        l.agregarFinal(7);
        l.agregarFinal(6);
        l.agregarFinal(9);
        l.agregarFinal(4);
        
        Lista l2 = new Lista();
        l2.agregarFinal(2);
        l2.agregarFinal(7);
        l2.agregarFinal(6);
        l2.agregarFinal(9);
        l2.agregarFinal(5);
        
        Lista l3 = new Lista();
        l3.agregarFinal(2);
        l3.agregarFinal(5);
        l3.agregarFinal(6);
        l3.agregarFinal(7);
        l3.agregarFinal(9);
        
        //l.mostrarInverso();
        //System.out.println("Suma = " + l.sumaPares());
        //System.out.println("Son iguales = " + l.sonIguales(l2));
        //System.out.println("Está ordenada = " + l3.estaOrdenada());
        
        int[][] mat = {{1,2,3},{4,5,6},{1,2,3}};
        //diagonalPrincipal(mat);
        System.out.println("Son filas iguales: " + mismasFilas(mat, 0, 2));
    }
    
    public static void diagonalPrincipal(int[][] mat){
        diagonalPrincipalRec(mat, 0);
    }
    
    public static void diagonalPrincipalRec(int[][] mat, int pos){
        if(pos < mat.length){
            System.out.println(mat[pos][pos]);
            diagonalPrincipalRec(mat, pos + 1);
        }
    }
    
    public static boolean mismasFilas(int mat[][], int fila1, int fila2){
        if(sonFilasValidas(fila1, fila2, mat.length - 1)){
            return mismasFilasRec(mat, fila1, fila2, 0);
        }else{
            return false;
        }
    }
    
    public static boolean sonFilasValidas(int fila1, int fila2, int tope){
        return fila1 >= 0 && fila2 >= 0 && fila1 <= tope && fila2 <= tope;
    }
    
    public static boolean mismasFilasRec(int mat[][], int fila1, int fila2, int col){
        if(mat[0].length - 1 == col){
            return mat[fila1][col] == mat[fila2][col];
        }
        
        return mat[fila1][col] == mat[fila2][col] && 
                mismasFilasRec(mat, fila1, fila2, col + 1);
    }
    
}
