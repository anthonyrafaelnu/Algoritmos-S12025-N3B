package tadlista;

public class ListaNodos<T extends Comparable> implements IListaSimple<T> {
    
    private NodoLista lista;
    private NodoLista fin;
    private int cantidad;

    public ListaNodos() {
        this.lista = null;
        this.cantidad = 0;
    }

    @Override
    public void agregarInicio(T x) {
        if(cantidad == 0){ // Es el primer nodo
            NodoLista nuevo = new NodoLista(x);
            nuevo.setSiguiente(null);
            lista = nuevo;
            fin = nuevo;
        }else{
            NodoLista nuevo = new NodoLista(x);
            nuevo.setSiguiente(lista);
            lista = nuevo;
        }
        cantidad++;
    }

    @Override
    public void mostrar() {
        NodoLista aux = lista;
        while(aux != null){
            System.out.print(aux.getDato() + " ");
            aux = aux.getSiguiente();
        }
    }

    @Override
    public int cantidadElementos() {
//        int contador = 0;
//        NodoLista<T> aux = lista;
//        while(aux.getSiguiente() != null){
//            contador++;
//            aux = aux.getSiguiente();
//        }
//        return contador;
        return cantidad;
    }

    @Override
    public boolean esVacia() {
        return lista == null;
    }

    @Override
    public void vaciar() {
        cantidad = 0;
        lista = null;
        fin = null;
    }

    @Override
    public boolean existeElemento(T x) {
        boolean existe = false;
        
        if(!esVacia()){
            NodoLista<T> aux = lista;
            while(aux != null && !existe){
                if(aux.getDato().equals(x)){
                    existe = true;
                }else{
                    aux = aux.getSiguiente();
                }
            }
        }
        
        return existe;
    }

    @Override
    public T obtenerElemento(int indice) {
        NodoLista<T> aux = lista;
        int pos = 0;
        
        while(aux != null && pos <= indice){
            if(pos == indice){
                return aux.getDato();
            }
            pos++;
            aux = aux.getSiguiente();
        }
        
        return null;
    }

    @Override
    public void agregarFinal(T x) {
        if(esVacia()){
            this.agregarInicio(x);
        }else{
            NodoLista nuevo = new NodoLista(x);
            fin.setSiguiente(nuevo);
            fin = fin.getSiguiente();
            cantidad++;
        }
    }

    @Override
    public void eliminarInicio() {
        if(cantidad == 1){
            vaciar();
        }else if(!esVacia()){
            NodoLista aBorrar = lista;
            lista = lista.getSiguiente();
            aBorrar.setSiguiente(null);
            cantidad--;
        }
    }

    @Override
    public void eliminarFinal() {
        if(!esVacia()){
            
            NodoLista<T> aux = lista;
            
            if(aux.getSiguiente() == null){
                vaciar();
            }else{
                while(aux.getSiguiente().getSiguiente() != null){
                    aux = aux.getSiguiente();
                }
                aux.setSiguiente(null);
                cantidad--;
            }
            
        }
    }

    @Override
    public void agregarOrdenado(T x) {
        if(esVacia() || x.compareTo(lista.getDato()) < 0){
            agregarInicio(x);
        }else{
            NodoLista<T> nuevo = new NodoLista(x);
            NodoLista<T> aux = lista;
            while(aux.getSiguiente() != null &&
                    aux.getSiguiente().getDato().compareTo(x) <= 0){
                aux = aux.getSiguiente();
            }
            
            if(aux.getSiguiente() == null){
                agregarFinal(x);
            }else{
                nuevo.setSiguiente(aux.getSiguiente());
                aux.setSiguiente(nuevo);
                cantidad++;
            }
            
        }
    }
    
}
