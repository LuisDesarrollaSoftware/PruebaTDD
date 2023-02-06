package org.campodeprueba.prueba.tdd.escuela.ficheros.formateadores;

import org.campodeprueba.prueba.tdd.escuela.Alumno;
import org.campodeprueba.prueba.tdd.escuela.Clase;

import java.util.ArrayList;
import java.util.List;

public abstract class Formateador {

    public Clase getClase(List<String> lineas) {
        Clase miclase = new Clase();
        List<Alumno> alumnos = new ArrayList<>();

        filtrarLineas(lineas);
        Alumno alumno= null;
        for (String linea : lineas) {
            procesaFila(miclase,alumnos, linea);
        }
        miclase.setAlumnos(alumnos);
        return miclase;
    }

    abstract void filtrarLineas(List<String> lineas);

    abstract void procesaFila(Clase miclase, List<Alumno> alumnos, String linea);


}
