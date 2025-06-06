package practico11;

public class Lista<T extends Comparable> implements ILista<T> {
    
    private Nodo lista;
    private Nodo fin;
    private int cantidad;

    public Lista() {
        this.lista = null;
        this.cantidad = 0;
    }

    @Override
    public void agregarInicio(T x) {
        if(cantidad == 0){ // Es el primer nodo
            Nodo nuevo = new Nodo(x);
            nuevo.setSiguiente(null);
            lista = nuevo;
            fin = nuevo;
        }else{
            Nodo nuevo = new Nodo(x);
            nuevo.setSiguiente(lista);
            lista = nuevo;
        }
        cantidad++;
    }

    @Override
    public void mostrar() {
        Nodo aux = lista;
        while(aux != null){
            System.out.print(aux.getDato() + " ");
            aux = aux.getSiguiente();
        }
    }

    @Override
    public int cantidadElementos() {
//        int contador = 0;
//        Nodo<T> aux = lista;
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
            Nodo<T> aux = lista;
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
        Nodo<T> aux = lista;
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
            Nodo nuevo = new Nodo(x);
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
            Nodo aBorrar = lista;
            lista = lista.getSiguiente();
            aBorrar.setSiguiente(null);
            cantidad--;
        }
    }

    @Override
    public void eliminarFinal() {
        if(!esVacia()){
            
            Nodo<T> aux = lista;
            
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
            Nodo<T> nuevo = new Nodo(x);
            Nodo<T> aux = lista;
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
    
    public void mostrarInverso(){
        mostrarInversoRec(this.lista);
    }
    
    public void mostrarInversoRec(Nodo lista){
        if(lista != null){ //CB
            mostrarInversoRec(lista.getSiguiente());
            if((int) lista.getDato() % 2 == 0){
                System.out.println(lista.getDato());
            }
        }
    }
    
    public int sumaPares(){
        return sumaParesRec(lista);
    }
    
    public int sumaParesRec(Nodo lista){
        int sum = 0;
        if(lista != null){
            if((int) lista.getDato() % 2 == 0){
                sum += (int)lista.getDato() + sumaParesRec(lista.getSiguiente());
            }else{
                sum += sumaParesRec(lista.getSiguiente());
            }
        }
        return sum;
    }
    
    public boolean sonIguales(Lista listaOtra){
        return sonIgualesRec(this.lista, listaOtra.lista);
    }
    
    public boolean sonIgualesRec(Nodo lista, Nodo lista2){
        if(lista == null && lista2 == null) return true;
        if((lista != null && lista2 == null) || lista == null && lista2 != null) return false;
        if(lista.getDato() == lista2.getDato()){
            return sonIgualesRec(lista.getSiguiente(), lista2.getSiguiente());
        }else{
            return false;
        }
    }
    
    public boolean estaOrdenada(){
        return estaOrdenadaRec(this.lista);
    }
    
    public boolean estaOrdenadaRec(Nodo lista){
        if(lista == null) return true; //CB: Lista vacía
        if(lista.getSiguiente() == null) return true; //CB: Lista un elemento
        if(lista.getDato().compareTo(lista.getSiguiente().getDato()) <= 0){
            return estaOrdenadaRec(lista.getSiguiente());
        }else{
            return false;
        }
    }
    
}
