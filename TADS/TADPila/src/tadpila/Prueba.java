package tadpila;

public class Prueba {

    public static void main(String[] args) {
        Pila p = new Pila();
        p.push(5);
        p.push(4);
        p.push(3);
        p.push(2);
        p.push(1);
        
        System.out.println(p.top());
    }

}
