package tadCola;

import java.util.Arrays;

public class TADCola {

    public static void main(String[] args) {
        Cola c = new Cola();
        
        c.encolar(1);
        c.encolar(2);
        c.encolar(4);
        c.encolar(4);
        c.encolar(4);
        
        System.out.print("Cola original: ");c.mostrar();
        
        eliminarRepetidos(c);
        System.out.println("");
        System.out.print("Cola resultado: ");c.mostrar();
//        System.out.println("");
//        System.out.println("Array resultado: " + Arrays.toString(datos(c)));
    
    
    }
    
    public static Object[] datos(Cola c){
        Object[] lista = new Object[c.cantidadElementos()];
        
        for (int i = 0; i < lista.length; i++) {
            lista[i] = c.front();
            c.encolar(c.front());
            c.desencolar();
        }
        
        return lista;
    }
    
    public static void eliminarRepetidos(Cola c){
        Object[] repetidos = new Object[c.cantidadElementos()];
        int cant = c.cantidadElementos();
        
        for (int i = 0; i < cant; i++) {
            if(estaEnArray(c.front(), repetidos)){
                c.desencolar();
            }else{
                repetidos[i] = c.front();
                c.encolar(c.front());
                c.desencolar();
            }
        }
    }
    
    public static boolean estaEnArray(Object o, Object[] lista){
        for (int i = 0; i < lista.length; i++) {
            Object object = lista[i];
            if(lista[i] != null && lista[i].equals(o)){
                return true;
            }
        }
        return false;
    }

}
