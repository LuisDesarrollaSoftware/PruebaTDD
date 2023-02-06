package org.campodeprueba.prueba.tdd.test.escuela.ficheros;

import org.campodeprueba.prueba.tdd.escuela.ficheros.Lector;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class LectorTest {

    @Test
    void testLeerLineasDeFicheroStandar() throws FileNotFoundException {
        Lector lector= new Lector(new File("src/test/resources/testfixture.txt"));
        List<String> lineas = lector.lee();
        MatcherAssert.assertThat(7, Matchers.greaterThanOrEqualTo(lineas.size()));
    }
    @Test
    void testLeerLineasDeFicheroTipoA() throws FileNotFoundException {
        Lector lector= new Lector(new File("src/test/resources/testfixtureA.txt"));
        List<String> lineas = lector.lee();
        MatcherAssert.assertThat(7, Matchers.greaterThanOrEqualTo(lineas.size()));
    }
    @Test
    void testLeerLineasDeFicheroTipoB() throws FileNotFoundException {
        Lector lector= new Lector(new File("src/test/resources/testfixtureB.txt"));
        List<String> lineas = lector.lee();
        MatcherAssert.assertThat(9, Matchers.greaterThanOrEqualTo(lineas.size()));
    }
}
