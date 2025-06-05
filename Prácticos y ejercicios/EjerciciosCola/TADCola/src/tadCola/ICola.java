package tadCola;

public interface ICola<T> {

    void encolar(T x);
    
    void desencolar();
    
    //PRE: No es vacía
    T front();
    
    boolean isEmpty();
    
    void vaciar();
    
    int cantidadElementos();
    
    //No corresponde, la dejamos para debug
    void mostrar();
}
