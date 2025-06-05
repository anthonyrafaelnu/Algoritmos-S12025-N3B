package tadlista;

public class TADLista {

    public static void main(String[] args) {
//        ListaV1 lista = new ListaV1(5);
//        lista.agregarFinal(2);
//        lista.agregarFinal(3);
//        lista.agregarFinal(4);
//        lista.mostrar();

          ListaNodos lista = new ListaNodos();
          lista.agregarOrdenado(6);
          lista.agregarOrdenado(2);
          lista.agregarOrdenado(4);
          lista.agregarOrdenado(1);
          lista.mostrar();
    }

}
