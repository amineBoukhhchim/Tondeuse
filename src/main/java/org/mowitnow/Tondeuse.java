package org.mowitnow;

/**
 * @author MA BOUKHCHIM
 */
class Tondeuse {
    int x, y;
    OriontationEnum orientation;

    public Tondeuse(int x, int y, OriontationEnum orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    /**
     * @param instruction ( direction de la tondeuse )
     * @param maxX ( point max X de pelouse )
     * @param maxY ( point max Y de pelouse )
     */
    public void avancer(DirectionEnum instruction, int maxX, int maxY) {
        switch (instruction) {
            case D: tournerDroite(); break;
            case G: tournerGauche(); break;
            case A: deplacer(maxX, maxY);
        }
    }

    /**
     * torner la tondeuse vers la droite
     */
    public void tournerDroite() {
        orientation = orientation.getNext();
    }

    /**
     * torner la tondeuse vers la gauche
     */
    public void tournerGauche() {
        orientation = orientation.getPrevious();
    }

    /**
     * @param maxX ( point max X de pelouse )
     * @param maxY( point max Y de pelouse )
     *
     * deplacer la tondeuse d'un pas selon l'orientation
     */
    public void deplacer(int maxX, int maxY) {
        if (orientation == OriontationEnum.N && y < maxY) {
            y++;
        } else if (orientation == OriontationEnum.E && x < maxX) {
            x++;
        } else if (orientation == OriontationEnum.S && y > 0) {
            y--;
        } else if (orientation == OriontationEnum.W && x > 0) {
            x--;
        }
    }

    /**
     * @return la position de la tondeuse
     */
    public String getPosition() {
        return x + " " + y + " " + orientation;
    }
}
