package org.campodeprueba.prueba.tdd.escuela.ficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lector {
    private File fichero;
    List<String> lineas;

    public Lector(File fichero) throws FileNotFoundException {
        this.fichero = fichero;
        lineas = lee();
    }

    public File getFichero() {
        return fichero;
    }

    public void setFichero(File fichero) {
        this.fichero = fichero;
    }

    public String getCabecera(){
        return this.lineas.get(0);
    }

    public List<String> lee() throws FileNotFoundException {
        List<String> lineas = new ArrayList<>();

        Scanner scanner = new Scanner(this.fichero);
        while (scanner.hasNext()){
            String linea = scanner.nextLine();
//            lineas.add(linea);
        }
        scanner.close();
        return lineas;
    }
}
