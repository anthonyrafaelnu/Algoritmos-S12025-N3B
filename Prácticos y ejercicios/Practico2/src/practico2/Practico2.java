package practico2;

import ej1.Persona;
import ej2.Socio;

public class Practico2 {

    public static void main(String[] args) {
        //Persona p = new Persona("Persona1", "Apellido1", 28);
        
        //System.out.println(p.toString());
        
        Socio s1 = new Socio("nombreSocio1");
        Socio s2 = new Socio("nombreSocio2");
        
        System.out.println(s1.toString());
        System.out.println(s2.toString());
        
        System.out.println("Siguiente número: " + Socio.proximoNumero);
    }
    
}
