package org.campodeprueba.prueba.tdd.test.escuela;

import org.campodeprueba.prueba.tdd.escuela.Nota;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NotaTest {

    Nota nota1 = null;
    Nota nota2 = null;
    Nota nota3 = null;
    Nota nota4 = null;
    Nota nota5 = null;
    Nota nota6 = null;
    Nota nota7 = null;
    Nota nota8 = null;
    Nota nota9 = null;
    Nota nota10 = null;
    @BeforeEach
    public void setUp(){
        //Arrange
        nota1 = new Nota(8,"lengua");
        nota2 = new Nota(8,"lengua");
        nota3 = new Nota(5,"matematicas");
        nota4 = new Nota(7,"matematicas");
        nota5 = new Nota(9,"lengua");
        nota6  = new Nota(5,"lengua");
        nota7  = new Nota(7,"lengua");
        nota8  = new Nota(5,"matematicas");
        nota9  = new Nota(7,"matematicas");
        nota10 = new Nota(9,"lengua");
    }

    @Test
    @DisplayName("Comprueba asignaturas iguales")
    void testMismaAsignatura(){

        //Act
        boolean esMisma = nota1.esMismaAsignatura(nota2);
        boolean esDistinta = nota1.esMismaAsignatura(nota3);

        //Assert => Confirmacion
        assertTrue(esMisma);
        assertFalse(esDistinta);

    }
    @Test
    @DisplayName("Comprueba asignaturas y notas iguales")
    void testMismaAsignaturaYNota(){


        //Act
        boolean esMisma = nota1.equals(nota2);
        boolean esDistinta = nota1.equals(nota3);

        //Assert => Confirmacion
        assertTrue(esMisma);
        assertFalse(esDistinta);
    }
    @Test
    @DisplayName("Comprueba una nota es mayor que otra")
    void testNotaEsMayorQueOtra(){

        //Act
        boolean esMayor = nota5.esMayor(nota1);
        boolean esMenor = nota1.esMayor(nota5);

        //Assert => Confirmacion
        assertTrue(esMayor);
        assertFalse(esMenor);
    }
    @Test
    @DisplayName("Comprueba una asignatura NO es comprable a otra")
    void testNotaNoEsComparableAOtra(){
        //Assert => Confirmacion
        assertThrows(RuntimeException.class,()-> nota1.esMayor(nota3));
    }
    @Test
    @DisplayName("Comprueba Tipo de nota 'BIEN'")
    void testNotaTipoBien(){
        //Assert => Confirmacion
        assertEquals(Nota.Tipo.BIEN,nota3.getTipo());
    }
    @Test
    @DisplayName("Comprueba Tipo de nota 'NOTABLE'")
    void testNotaTipoNotable(){
        //Assert => Confirmacion
        assertEquals(Nota.Tipo.NOTABLE,nota4.getTipo());
    }
}
