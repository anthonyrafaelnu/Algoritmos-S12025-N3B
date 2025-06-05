package tadCola;

public class Cola<T extends Comparable> implements ICola<T> {
    
    private Nodo<T> cola;
    private Nodo<T> fin;
    private int cantidad;

    public Cola() {
        this.cola = null;
        this.cantidad = 0;
    }
    
    @Override
    public void encolar(T x) {
        Nodo nuevo = new Nodo(x);
        if(isEmpty()){
            this.cola = nuevo;
            this.fin = nuevo;
        }else{
            fin.setSiguiente(nuevo);
            fin = fin.getSiguiente();
        }
        cantidad++;
    }
    
    @Override
    public void desencolar() {
        if(cantidad == 1){
            vaciar();
        }else if(!isEmpty()){
            Nodo aBorrar = cola;
            cola = cola.getSiguiente();
            aBorrar.setSiguiente(null);
            cantidad--;
        }
    }
    
    @Override
    public T front() {
        if(!this.isEmpty()){
            return this.cola.getDato();
        }
        return null;
    }
    
    @Override
    public boolean isEmpty() {
        return cola == null;
    }
    
    @Override
    public void vaciar() {
        cantidad = 0;
        cola = null;
        fin = null;
    }
    
    @Override
    public int cantidadElementos() {
        return cantidad;
    }
    
    
    @Override
    public void mostrar() {
        Nodo aux = cola;
        while(aux != null){
            System.out.print(aux.getDato() + " ");
            aux = aux.getSiguiente();
        }
    }
    
    
}
