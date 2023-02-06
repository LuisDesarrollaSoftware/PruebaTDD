package org.campodeprueba.prueba.tdd.escuela;

import java.util.Objects;

public class Nota {

    private double valor;
    private String asignatura;
    private Alumno alumno;

    public enum Tipo{
        MUYDEFICIENTE,INSUFICIENTE,BIEN,NOTABLE,SOBRESALIENTE
    }

    public Nota(double valor, String asignatura) {
        this.valor = valor;
        this.asignatura = asignatura;
        this.alumno = alumno;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public boolean esMismaAsignatura(Nota otra){
        if(this.getAsignatura().equals(otra.getAsignatura())){
            return true;
        }else{
            return false;
        }
    }
    public boolean esMayor(Nota otra){
        if(esMismaAsignatura(otra)){
            if (this.getValor()>otra.getValor()){
                return true;
            }else{
                return false;
            }
        }else{
            throw new RuntimeException("Las notas no son comparables por no compartir asignatura.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nota nota = (Nota) o;
        return Double.compare(nota.valor, valor) == 0 && asignatura.equals(nota.asignatura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor, asignatura);
    }

    public Tipo getTipo(){
        if(getValor() >= 0 && getValor() < 3){
            return Tipo.MUYDEFICIENTE;
        }else if(getValor() >= 3 && getValor() < 5){
            return Tipo.INSUFICIENTE;
        }else if(getValor() >= 5 && getValor() < 7){
            return Tipo.BIEN;
        }else if(getValor() >= 7 && getValor() < 9){
            return Tipo.NOTABLE;
        }else{
            return Tipo.SOBRESALIENTE;
        }
    }
}
