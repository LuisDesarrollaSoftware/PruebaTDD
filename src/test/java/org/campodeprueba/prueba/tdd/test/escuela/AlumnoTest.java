package org.campodeprueba.prueba.tdd.test.escuela;


import org.campodeprueba.prueba.tdd.escuela.Alumno;
import org.campodeprueba.prueba.tdd.escuela.Nota;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

//import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlumnoTest {
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
    @DisplayName("AgregarNota")
    void testAddNota() {
        //Arrage
        juan.setNotas(new ArrayList<>(notas));
        Nota nota3 = new Nota(8, "lengua");
        //Act
        juan.getNotas().add(nota3);
        //Assert
        assertThat(juan.getNotas(), hasItem(nota3));
    }

    @Test
    @DisplayName("BorrarNota")
    void testBorrarNota() {
        //Arrage
        juan.setNotas( new ArrayList<Nota>(notas));
        //Act
        juan.getNotas().remove(nota2);
        //Assert
        assertThat(juan.getNotas(),not(hasItem(nota2)));
    }

    @Test
    void testObtenerPeorNotaAlumno(){
        //Arrage
        juan.setNotas(new ArrayList<>(notas));
        Nota nota3 = new Nota(0, "educacion fisica");
        //Act
        juan.getNotas().add(nota3);
        juan.getPeorNota();

        assertThat(juan.getPeorNota().getValor(), Matchers.lessThanOrEqualTo(new Nota(0, "fisica").getValor()));
    }
    @Test
    void testObtenerMejorNotaAlumno(){
        //Arrage
        juan.setNotas(new ArrayList<>(notas));
        Nota nota3 = new Nota(10, "lengua");
        //Act
        juan.getNotas().add(nota3);
        juan.getMejorNota();
        //asserts
        assertThat(juan.getMejorNota().getValor(), Matchers.greaterThanOrEqualTo(new Nota(9, "fisica").getValor()));
    }
    @Test
    void testIgualdadEntreAlumnos(){
        //Arrage
        Alumno alumno1 = new Alumno("juan");
        Alumno alumno2 = new Alumno("juan");
        //Act
        //asserts
        assertThat(alumno1, equalTo(alumno2));
    }


    @AfterEach
    void  tearDown(){
        notas=null;
    }
}


