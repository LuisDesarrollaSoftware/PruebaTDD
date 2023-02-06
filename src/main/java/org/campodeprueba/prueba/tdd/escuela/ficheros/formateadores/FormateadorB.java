package org.campodeprueba.prueba.tdd.escuela.ficheros.formateadores;

import org.campodeprueba.prueba.tdd.escuela.Alumno;
import org.campodeprueba.prueba.tdd.escuela.Clase;
import org.campodeprueba.prueba.tdd.escuela.Nota;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class FormateadorB extends Formateador{

    void procesaFila(Clase miclase, List<Alumno> alumnos, String linea) {
        if (Pattern.compile("^[A-Za-z]").matcher(linea).find()) {
            Alumno alumno = new Alumno();
            alumno.setNombre(linea);
            alumnos.add(alumno);
        } else {
            String[] datosLinea = linea.split(",");
            Nota nota = new Nota(Double.parseDouble(datosLinea[0]), datosLinea[1]);
            Alumno alumno = alumnos.get(alumnos.size()-1);
            alumno.addNota(nota);
        }
    }

    void filtrarLineas(List<String> lineas) {
        lineas.removeIf((linea) -> linea.contains("-"));
        lineas.removeIf((linea) -> linea.contains("*"));
    }
}
