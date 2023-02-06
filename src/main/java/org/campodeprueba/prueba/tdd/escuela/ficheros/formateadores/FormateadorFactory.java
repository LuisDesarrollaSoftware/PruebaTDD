package org.campodeprueba.prueba.tdd.escuela.ficheros.formateadores;

public class FormateadorFactory {

    public static Formateador getInstance(String cabecera){
        Formateador formateador= null;
        if (cabecera.contains("*")) {
            formateador = new FormateadorStandar();
        } else if (cabecera.contains("/")) {
            formateador = new FormateadorA();
        } else {
            formateador = new FormateadorB();
        }
        return formateador;
    }
}
