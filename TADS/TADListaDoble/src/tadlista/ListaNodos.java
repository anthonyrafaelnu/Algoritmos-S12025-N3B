package tadlista;

public class ListaNodos<T extends Comparable> implements IListaDoble<T> {
    
    private NodoListaDoble lista;
    private NodoListaDoble fin;
    private int cantidad;

    public ListaNodos() {
        this.lista = null;
        this.cantidad = 0;
    }

    @Override
    public void agregarInicio(T x) {
        if(cantidad == 0){ // Es el primer nodo
            NodoListaDoble nuevo = new NodoListaDoble(x);
            lista = nuevo;
            fin = nuevo;
        }else{
            NodoListaDoble nuevo = new NodoListaDoble(x);
            nuevo.setSiguiente(lista);
            lista.setAnterior(nuevo);
            lista = nuevo;
        }
        cantidad++;
    }

    @Override
    public void mostrar() {
        NodoListaDoble aux = lista;
        while(aux != null){
            System.out.print(aux.getDato() + " ");
            aux = aux.getSiguiente();
        }
    }

    @Override
    public int cantidadElementos() {
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
            NodoListaDoble<T> aux = lista;
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
        NodoListaDoble<T> aux = lista;
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
            NodoListaDoble nuevo = new NodoListaDoble(x);
            fin.setSiguiente(nuevo);
            nuevo.setAnterior(fin);
            //fin = fin.getSiguiente();
            fin = nuevo;
            cantidad++;
        }
    }

    @Override
    public void eliminarInicio() {
        if(cantidad == 1){
            vaciar();
        }else if(!esVacia()){
            NodoListaDoble aBorrar = lista;
            lista = lista.getSiguiente();
            lista.setAnterior(null);
            aBorrar.setSiguiente(null);
            cantidad--;
        }
    }

    @Override
    public void eliminarFinal() {
        if(!esVacia()){
            
            NodoListaDoble<T> aux = lista;
            
            if(aux.getSiguiente() == null){
                vaciar();
            }else{
                NodoListaDoble<T> aBorrar = fin;
                fin = fin.getAnterior();
                fin.setSiguiente(null);
                aBorrar.setAnterior(null);
                cantidad--;
            }
            
        }
    }

    @Override
    public void agregarOrdenado(T x) {
        if(esVacia() || x.compareTo(lista.getDato()) < 0){
            agregarInicio(x);
        }else{
            NodoListaDoble<T> nuevo = new NodoListaDoble(x);
            NodoListaDoble<T> aux = lista;
            while(aux.getSiguiente() != null &&
                    aux.getSiguiente().getDato().compareTo(x) <= 0){
                aux = aux.getSiguiente();
            }
            
            if(aux.getSiguiente() == null){
                agregarFinal(x);
            }else{
                NodoListaDoble<T> auxSig = aux.getSiguiente();
                aux.setSiguiente(nuevo);
                nuevo.setSiguiente(auxSig);
                nuevo.setAnterior(aux);
                auxSig.setAnterior(nuevo);
                cantidad++;
            }
            
        }
    }
    
}
