package org.campodeprueba.prueba.tdd.test.escuela.formateadores;

import org.campodeprueba.prueba.tdd.escuela.Alumno;
import org.campodeprueba.prueba.tdd.escuela.Clase;
import org.campodeprueba.prueba.tdd.escuela.Nota;
import org.campodeprueba.prueba.tdd.escuela.ficheros.Lector;
import org.campodeprueba.prueba.tdd.escuela.ficheros.formateadores.Formateador;
import org.campodeprueba.prueba.tdd.escuela.ficheros.formateadores.FormateadorStandar;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class FormateadorStandarTest {

    @Mock
    Lector lector;

    @Test
    void testObtenerClaseConAlumnosFormatoStandar() throws FileNotFoundException {
        List<String> lineasFixture = new ArrayList<>();
        lineasFixture.add("****************************");
        lineasFixture.add("antonio,matematicas,7.5");
        lineasFixture.add("antonio,lengua,8");
        lineasFixture.add("-----------------------");
        lineasFixture.add("gema,matematicas,5");
        lineasFixture.add("gema,lengua,9");
        lineasFixture.add("****************************");

        //        Mockito.when(lector.lee()).thenReturn(lineasFixture);

        Formateador formateador = new FormateadorStandar();
        Clase miclase = formateador.getClase(lineasFixture);
        List<Alumno> alumnos= miclase.getAlumnos();

        MatcherAssert.assertThat(
                alumnos.size(),
                Matchers.equalTo(2)
        );

        MatcherAssert.assertThat(
                alumnos,
                Matchers.hasItem(new Alumno("antonio"))
        );
        MatcherAssert.assertThat(
                alumnos.get(0).getNotas().size(),
                Matchers.equalTo(2)
        );

        MatcherAssert.assertThat(
                alumnos.get(0).getNotas(),
                Matchers.hasItem(new Nota(7.5,"matematicas"))
        );

        MatcherAssert.assertThat(
                alumnos,
                Matchers.hasItem(new Alumno("gema"))
        );
        MatcherAssert.assertThat(
                alumnos.get(1).getNotas().size(),
                Matchers.equalTo(2)
        );
        MatcherAssert.assertThat(
                alumnos.get(1).getNotas(),
                Matchers.hasItem(new Nota(5,"matematicas"))
        );
    }
}