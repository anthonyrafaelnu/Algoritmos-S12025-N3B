package tadpila;

public interface IPila<T> {

    void push(T x);
    
    T top();

    int cantidadElementos();

    boolean esVacia();

    void vaciar();

    void pop();
    
    void mostrar();
}
