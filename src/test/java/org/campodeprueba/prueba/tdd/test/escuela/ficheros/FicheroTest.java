package org.campodeprueba.prueba.tdd.test.escuela.ficheros;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FicheroTest {

    @Test
    void test() throws FileNotFoundException {
        List<String> lineas = new ArrayList<>();

        Scanner scanner = new Scanner(new File("src/test/resources/testfixture.txt"));
        while (scanner.hasNext()){
            String linea = scanner.nextLine();
            lineas.add(linea);
        }
        MatcherAssert.assertThat(
                7,
                Matchers.greaterThanOrEqualTo(lineas.size())
        );
    }

}
