package ordenacion;

import java.util.Arrays;

public class Ordenacion {

    public static void main(String[] args) {
        int[] lista = {45,2,12,45,8,7,66,70};
        //int[] listaInversa = {66,70,45,45,12,8,7,2};
        
        //System.out.println("Lista antes de ordenar: " + Arrays.toString(lista));
        //bubbleSort(listaInversa);
        //bubbleSortOptimizado(lista);
        //selectionSort(lista);
        insertionSort(lista);
        System.out.println("Lista ordenada: " + Arrays.toString(lista));
        // Espero: [2,7,8,12,45,45,66,70]
    }
    
    public static void bubbleSort(int[] lista){
        
        int comparaciones = 0;
        int intercambios = 0;
        
        for (int i = 0; i < lista.length - 1; i++) {
            for (int j = 0; j < lista.length - 1 - i; j++) {
                comparaciones++;
                int val = lista[j];
                int valSig = lista[j+1];
                if(val > valSig){
                    lista[j] = valSig;
                    lista[j+1] = val;
                    intercambios++;
                }
            }
        }
        
        System.out.println("Cant comparaciones: " + comparaciones);
        System.out.println("Cant intercambios: " + intercambios);
    }
    
    public static void bubbleSortOptimizado(int[] lista){
        
        int comparaciones = 0;
        int intercambios = 0;
        
        boolean estaOrdenada = false;
        
        for (int i = 0; i < lista.length - 1 && !estaOrdenada; i++) {
            
            estaOrdenada = true;
            
            for (int j = 0; j < lista.length - 1 - i; j++) {
                comparaciones++;
                int val = lista[j];
                int valSig = lista[j+1];
                if(val > valSig){
                    lista[j] = valSig;
                    lista[j+1] = val;
                    intercambios++;
                    estaOrdenada = false;
                }
            }
        }
        
        System.out.println("Cant comparaciones: " + comparaciones);
        System.out.println("Cant intercambios: " + intercambios);
    }
    
    public static void selectionSort(int[] lista){
        
        int comparaciones = 0;
        int intercambios = 0;
        int cambios = 0;
        
        boolean estaOrdenada = false;
        for (int i = 0; i < lista.length - 1 && !estaOrdenada; i++) {
            
            estaOrdenada = true;
            int posMin = i;
            
            for (int j = i+1; j < lista.length; j++) {
                comparaciones++;
                if(lista[j] < lista[posMin]){
                    cambios++;
                    posMin = j;
                    estaOrdenada = false;
                }
            }
            
            int aux = lista[posMin];
            lista[posMin] = lista[i];
            lista[i] = aux;
            intercambios++;
        }
        
        System.out.println("Cant comparaciones: " + comparaciones);
        System.out.println("Cant intercambios: " + intercambios);
        System.out.println("Cant cambios: " + cambios);
    }
    
    public static void insertionSort(int[] lista){
        for (int i = 1; i < lista.length; i++) {
            int aInsertar = lista[i];
            int j = i - 1;
            
            while(j >= 0 && lista[j] > aInsertar){
                lista[j+1] = lista[j];
                j--;
            }
            
            lista[j+1] = aInsertar;
        }
    }
    
}
