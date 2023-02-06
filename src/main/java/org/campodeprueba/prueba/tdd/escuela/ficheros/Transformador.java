package org.campodeprueba.prueba.tdd.escuela.ficheros;

import org.campodeprueba.prueba.tdd.escuela.Clase;
import org.campodeprueba.prueba.tdd.escuela.ficheros.formateadores.Formateador;

import java.io.FileNotFoundException;
import java.util.List;

public class Transformador {
    private Lector lector;
    private Formateador formateador;

    public Transformador(Lector lector) {
        this.lector = lector;
    }

    public Transformador(Lector lector, Formateador formateador) {
        this.lector = lector;
        this.formateador = formateador;
    }

    public Lector getLector() {
        return lector;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }

    public Formateador getFormateador() {
        return formateador;
    }

    public void setFormateador(Formateador formateador) {
        this.formateador = formateador;
    }

    public Clase getClase() throws FileNotFoundException {

        Clase miclase = null;
        List<String> lineas = lector.lee();
        miclase=formateador.getClase(lineas);
        return miclase;
    }
}
