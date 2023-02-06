package org.campodeprueba.prueba.tdd.escuela.ficheros.formateadores;

import org.campodeprueba.prueba.tdd.escuela.Alumno;
import org.campodeprueba.prueba.tdd.escuela.Clase;
import org.campodeprueba.prueba.tdd.escuela.Nota;

import java.util.ArrayList;
import java.util.List;

public class FormateadorA extends Formateador {
    void procesaFila(Clase miclase,List<Alumno> alumnos, String linea) {

//        Alumno alumno;
        String[] datosLinea = linea.split(",");

        Alumno alumno = new Alumno();
        alumno.setNombre(datosLinea[0]);

        int posicion = alumnos.indexOf(alumno);
        if (posicion == -1) {
            alumnos.add(alumno);
        } else {
            alumno = alumnos.get(posicion);
        }

        alumno.addNota(new Nota(Double.parseDouble(datosLinea[2]), datosLinea[1]));
    }

    void filtrarLineas(List<String> lineas) {
        lineas.removeIf((linea) -> linea.contains("/"));
        lineas.removeIf((linea) -> linea.contains("*"));
    }
}
