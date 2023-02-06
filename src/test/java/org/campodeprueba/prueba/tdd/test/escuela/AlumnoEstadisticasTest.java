package org.campodeprueba.prueba.tdd.test.escuela;

import org.campodeprueba.prueba.tdd.escuela.Alumno;
import org.campodeprueba.prueba.tdd.escuela.Nota;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AlumnoEstadisticasTest {
    Alumno juan;
    Nota nota1;
    Nota nota2;
    List<Nota> notas;

    @BeforeEach
    void setUp() {
        //Arrage
        notas = new ArrayList<>();
        juan = new Alumno(notas, "juan");
        nota1 = new Nota(8, "lengua");
        nota2 = new Nota(7, "lengua");
        notas.add(nota1);
        notas.add(nota2);
    }

    @Test
    void testObtenerSobresalientes() {
        //Arrage
        juan.setNotas(new ArrayList<>(notas));
        juan.getNotas().add(new Nota(9, "matematicas"));
        juan.getNotas().add(new Nota(9, "lengua"));

        //Act
        int sobresalientes=juan.getSobresaliente();

        //Assert
        assertThat(2,equalTo(sobresalientes));

    }
    @Test
    void testObtenerSuspensos() {
        //Arrage
        juan.setNotas(new ArrayList<>());
        juan.getNotas().add(new Nota(7, "lengua"));
        juan.getNotas().add(new Nota(4, "ingles"));
        juan.getNotas().add(new Nota(3, "matematicas"));

        //Act
        int sobresalientes=juan.getSuspensos();

        //Assert
        assertThat(5.0,equalTo(juan.getNotaMedia()));

    }

    @Test
    void testObtenerInsuficientes() {
        //Arrage
        juan.setNotas(new ArrayList<>(notas));
        juan.getNotas().add(new Nota(2, "ingles"));
        juan.getNotas().add(new Nota(3, "matematicas"));
        //Act
        int sobresalientes=juan.getInsuficietes();
        //Assert
        assertThat(2,equalTo(sobresalientes));

    }

    @Test
    void testObtenerMediaAlumno() {
        //Arrage
        juan.setNotas(new ArrayList<>(notas));
        juan.getNotas().add(new Nota(2, "ingles"));
        juan.getNotas().add(new Nota(3, "matematicas"));
        //Act
        int sobresalientes=juan.getInsuficietes();
        //Assert
        assertThat(2,equalTo(sobresalientes));

    }

    @AfterEach
    void  tearDown(){
        notas=null;
    }
}
