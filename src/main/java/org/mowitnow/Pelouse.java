package org.mowitnow;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * @author MA BOUKHCHIM
 */
public class Pelouse {

    public static void main(String[] args) {
        creationPelouse("src/main/resources/input.txt");
    }

    /**
     * @param fileName
     * Creation du Pelouse avec les tondeuse à partir d'un fichier
     */
    public static void creationPelouse(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            int maxX = scanner.nextInt();
            int maxY = scanner.nextInt();

            while (scanner.hasNext()) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                OriontationEnum orientation = OriontationEnum.valueOf(
                        String.valueOf(scanner.next().charAt(0)));
                // scanner.nextLine();
                String instructions = scanner.next();

                Tondeuse tondeuse = new Tondeuse(x, y, orientation);
                instructions.chars()
                        .mapToObj(c -> String.valueOf((char) c))
                        .forEach(c -> {
                            DirectionEnum direction = DirectionEnum.valueOf(c);
                            tondeuse.avancer(direction, maxX, maxY);
                        });


                System.out.println(tondeuse.getPosition());
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Vérifier le fichier");
        } catch (IllegalArgumentException e1) {
            System.out.println("Vérifier le contenue de fichier");
        }
    }
}