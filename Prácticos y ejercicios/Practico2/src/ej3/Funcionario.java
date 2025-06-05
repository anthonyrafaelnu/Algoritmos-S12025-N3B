package ej3;

import java.util.Objects;

public abstract class Funcionario implements Comparable<Funcionario> {
    private String nombre;
    private String ci;
    
    public abstract double calcularSueldo();

    @Override
    public boolean equals(Object obj) {
        Funcionario func = (Funcionario) obj;
        return Objects.equals(this.ci, func.ci);
    }
    
    public static boolean ganaMas(Funcionario f1, Funcionario f2){
        return f1.calcularSueldo() > f2.calcularSueldo();
    }
    
    public boolean ganaMasQue(Funcionario f2){
        return this.calcularSueldo() > f2.calcularSueldo();
    }

    @Override
    public int compareTo(Funcionario f) {
        return -1 * Double.compare(this.calcularSueldo(), f.calcularSueldo());
    }

    
    
    
}
