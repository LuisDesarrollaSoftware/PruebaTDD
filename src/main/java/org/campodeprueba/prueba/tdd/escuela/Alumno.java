package org.campodeprueba.prueba.tdd.escuela;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Alumno {
    private List<Nota> notas = new ArrayList<Nota>();
    private String nombre;

    public Alumno() {

    }
    public Alumno(List<Nota> notas, String nombre) {
        this.notas = notas;
        this.nombre = nombre;
    }

    public Alumno(String nombre) {
        this.nombre = nombre;
    }


    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void addNota(Nota nota) {
        this.notas.add(nota);
    }

    public void removeNota(Nota nota) {
        this.notas.remove(nota);
    }

    public int getSobresaliente() {
        int result = 0;
        for (Nota n : this.getNotas()) {
            if (n.getValor() >= 9) {
                result++;
            }
        }
        return result;
    }

    public int getSuspensos() {
        int result = 0;
        for (Nota n : this.getNotas()) {
            if (n.getValor() <= 4) {
                result++;
            }
        }
        return result;
    }

    public int getInsuficietes() {
        int result = 0;
        for (Nota n : this.getNotas()) {
            if (n.getValor() <= 3) {
                result++;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder notasSb = new StringBuilder();

        for (Nota n : notas) {
            notasSb.append(" Nota: ");
            notasSb.append(n.getValor());
            notasSb.append(" Asignatura: ");
            notasSb.append(n.getAsignatura());
            notasSb.append(" Tipo: ");
            notasSb.append(n.getTipo());
        }

        return "Alumno{" +
                "notas=" + notasSb.toString() +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    public Nota getMejorNota() {
        double mejor = 0;
        Nota mejorNota = null;
        for (Nota nota : this.notas) {
            if (nota.getValor() >= mejor) {
                mejor = nota.getValor();
                mejorNota = nota;
            }
        }
        return mejorNota;
    }

    public Nota getPeorNota() {
        double peor = 10;
        Nota peorNota = null;
        for (Nota nota : this.notas) {
            if (nota.getValor() <= peor) {
                peor = nota.getValor();
                peorNota = nota;
            }
        }
        return peorNota;
    }

    public double getNotaMedia() {
        double sumatorio = 1;
        for (Nota nota : this.notas) {
            sumatorio += nota.getValor();
        }
        return sumatorio / this.notas.size();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return nombre.equals(alumno.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notas, nombre);
    }
}
