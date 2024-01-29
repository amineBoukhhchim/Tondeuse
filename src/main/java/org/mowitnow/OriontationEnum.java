package org.mowitnow;
/**
 * @author MA BOUKHCHIM
 * Orientation
 */
enum OriontationEnum {
    /**
     * North
     */
    N,
    /**
     * East
     */
    E,
    /**
     * South
     */
    S,
    /**
     * West
     */
    W;

    /**
     * @return OriontationEnum
     * retourner la valeur suivante
     */
    public OriontationEnum getNext() {
        return values()[(ordinal() + 1) % values().length];
    }

    /**
     * @return OriontationEnum
     * retourner la valeur precedente
     */
    public OriontationEnum getPrevious() {
        return values()[(ordinal() - 1 + values().length) % values().length];
    }
}
