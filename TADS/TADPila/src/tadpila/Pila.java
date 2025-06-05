package tadpila;

public class Pila<T extends Comparable> implements IPila<T> {
    
    private Nodo<T> pila;
    private int cantidad;

    public Pila() {
        this.pila = null;
        this.cantidad = 0;
    }

    @Override
    public void push(T x) {
        if(cantidad == 0){ // Es el primer nodo
            Nodo nuevo = new Nodo(x);
            nuevo.setSiguiente(null);
            pila = nuevo;
        }else{
            Nodo nuevo = new Nodo(x);
            nuevo.setSiguiente(pila);
            pila = nuevo;
        }
        cantidad++;
    }

    @Override
    public T top() {
        return this.pila.getDato();
    }

    @Override
    public int cantidadElementos() {
        return cantidad;
    }

    @Override
    public boolean esVacia() {
        return pila == null;
    }

    @Override
    public void vaciar() {
        cantidad = 0;
        pila = null;
    }

    @Override
    public void pop() {
        if(cantidad == 1){
            vaciar();
        }else if(!esVacia()){
            Nodo aBorrar = pila;
            pila = pila.getSiguiente();
            aBorrar.setSiguiente(null);
            cantidad--;
        }
    }
    
    // Esta función no es válida, pero la dejamos para pruebas
    @Override
    public void mostrar() {
        Nodo aux = pila;
        while(aux != null){
            System.out.print(aux.getDato() + " ");
            aux = aux.getSiguiente();
        }
    }
    
}
