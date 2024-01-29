package org.mowitnow;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class TondeuseTest {

    int initialX = 1, initialY = 2;
    int maxX = 5, maxY =5;

    @Test
    public void testTondeuse() {
        OriontationEnum initialOrientation = OriontationEnum.N;
        Tondeuse tondeuse = new Tondeuse(initialX, initialY, initialOrientation);
        String instructions = "GAGAGAGAA";
        for (char instruction : instructions.toCharArray()) {
            tondeuse.avancer(DirectionEnum.valueOf(String.valueOf(instruction)), maxX, maxY);
        }
        String expectedPosition = "1 3 N";
        Assertions.assertEquals(expectedPosition, tondeuse.getPosition());
    }

    @Test
    public void testTournerDroiteMethode() {
        OriontationEnum initialOrientation = OriontationEnum.N;
        Tondeuse tondeuse = new Tondeuse(initialX, initialY, initialOrientation);
        tondeuse.tournerDroite();
        Assertions.assertEquals(initialX + " " + initialY + " " + "E", tondeuse.getPosition());
        tondeuse.tournerDroite();
        Assertions.assertEquals(initialX + " " + initialY + " " + "S", tondeuse.getPosition());
        tondeuse.tournerDroite();
        Assertions.assertEquals(initialX + " " + initialY + " " + "W", tondeuse.getPosition());
        tondeuse.tournerDroite();
        Assertions.assertEquals(initialX + " " + initialY + " " + "N", tondeuse.getPosition());
    }

    @Test
    public void testTournerGaucheMethode() {
        OriontationEnum initialOrientation = OriontationEnum.N;
        Tondeuse tondeuse = new Tondeuse(initialX, initialY, initialOrientation);
        tondeuse.tournerGauche();
        Assertions.assertEquals(initialX + " " + initialY + " " + "W", tondeuse.getPosition());
        tondeuse.tournerGauche();
        Assertions.assertEquals(initialX + " " + initialY + " " + "S", tondeuse.getPosition());
        tondeuse.tournerGauche();
        Assertions.assertEquals(initialX + " " + initialY + " " + "E", tondeuse.getPosition());
        tondeuse.tournerGauche();
        Assertions.assertEquals(initialX + " " + initialY + " " + "N", tondeuse.getPosition());
    }

}