package org.campodeprueba.prueba.tdd.test.escuela.formateadores;

import org.campodeprueba.prueba.tdd.escuela.ficheros.formateadores.Formateador;
import org.campodeprueba.prueba.tdd.escuela.ficheros.formateadores.FormateadorFactory;
import org.campodeprueba.prueba.tdd.escuela.ficheros.formateadores.FormateadorStandar;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FactoryTest {
    @Test
    void test() {
        Formateador formateador = FormateadorFactory.getInstance("*************");
        Assertions.assertTrue(formateador instanceof FormateadorStandar);
    }
}
