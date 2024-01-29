package org.mowitnow;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class PelouseTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test()
    public void testFihierInexistant() {
        Pelouse.creationPelouse("");
        Assertions.assertTrue(outputStreamCaptor.toString().contains("Vérifier le fichier"));
    }
    @Test()
    public void testFihierIncoherant() {
        Pelouse.creationPelouse("src/test/resources/input.txt");
        Assertions.assertTrue(outputStreamCaptor.toString().contains("Vérifier le contenue de fichier"));
    }
    @Test()
    public void testFihierOk() {
        Pelouse.creationPelouse("src/main/resources/input.txt");
        Assertions.assertTrue(outputStreamCaptor.toString().contains("1 3 N"));
        Assertions.assertTrue(outputStreamCaptor.toString().contains("5 1 E"));
    }

}