package org.campodeprueba.prueba.tdd.test.escuela;

import org.campodeprueba.prueba.tdd.escuela.Alumno;
import org.campodeprueba.prueba.tdd.escuela.Clase;
import org.campodeprueba.prueba.tdd.escuela.Nota;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class ClaseTest {

    @Mock
    Alumno juan, pepe;

    @Test
    void addAlumno() {
        //arrage
        Alumno alumno = new Alumno("juan");
        List<Alumno> alumnos = new ArrayList<>();
        alumnos.add(alumno);
        Clase clase = new Clase("1A", alumnos);
        //Act
        clase.addAlumno(new Alumno("jose"));
        //Assert
        MatcherAssert.assertThat(clase.getAlumnos(), Matchers.hasItem(new Alumno("jose")));
    }

    @Test
    void removeAlumno() {
        //arrage
        Alumno alumno = new Alumno("juan");
        List<Alumno> alumnos = new ArrayList<>();
        alumnos.add(alumno);
        Clase clase = new Clase("1A", alumnos);
        clase.addAlumno(new Alumno("jose"));
        //Act
        clase.removeAlumno(new Alumno("jose"));
        //Assert
        MatcherAssert.assertThat(clase.getAlumnos(), Matchers.not(Matchers.hasItem(new Alumno("jose"))));

    }

    @Test
    void getMedia() {
        //Stabs
//        Alumno juan = Mockito.mock(Alumno.class);
        Mockito.when(juan.getNotaMedia()).thenReturn(6.2);
//        Alumno pepe = Mockito.mock(Alumno.class);
        Mockito.when(pepe.getNotaMedia()).thenReturn(7.1);

        List<Alumno> alumnos = new ArrayList<>();
        alumnos.add(juan);
        alumnos.add(pepe);
        Clase clase = new Clase("1A", alumnos);

        //Act
        double mediaClase =clase.getMedia();
        //Assert
        MatcherAssert.assertThat(mediaClase,Matchers.closeTo(6.6,0.2));
    }

    @Test
    void getMejorNota() {
        //Stabs
//        Alumno juan = Mockito.mock(Alumno.class);
        Mockito.when(juan.getMejorNota()).thenReturn(new Nota(8,"lengua"));
//        Alumno pepe = Mockito.mock(Alumno.class);
        Mockito.when(pepe.getMejorNota()).thenReturn(new Nota(10,"matematicas"));

        List<Alumno> alumnos = new ArrayList<>();
        alumnos.add(juan);
        alumnos.add(pepe);
        Clase clase = new Clase("1A", alumnos);

        //Act
        Nota mejorNota =clase.getMejorNota();
        //Assert
        MatcherAssert.assertThat(
                mejorNota,
                Matchers.equalTo(new Nota(10,"matematicas"))
        );

        //Verifica el numero de veces que se ejecuta el metodo de cada objeto Alumno
        Mockito.verify(juan,Mockito.times(1)).getMejorNota();
        Mockito.verify(pepe,Mockito.times(1)).getMejorNota();
    }
}