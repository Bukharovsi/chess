package ru.bukharovsi.chess.domains.chessmans;


import ru.bukharovsi.chess.domains.Colour;
import ru.bukharovsi.chess.domains.field.Cell;
import ru.bukharovsi.chess.domains.field.Coordinate;

import java.util.Collection;

/**
 * A shape of chess.
 * Can be a king, queen, pawn and so on.
 * Of course, has a Colour and position. Also can goto another cell, hack another chessman.
 */
public interface Chessman {

    /**
     * Represents chessman colour. Black or White
     * @return
     */
    Colour colour();

    /**
     * Move this chessman to new location
     * @param cell new location
     */
    void goTo(Cell cell);

    /**
     * This chessman was hacked
     */
    void killedBy(Chessman killer);

    /**
     * Is not hacked
     */
    boolean isAlive();

    /**
     * Is possible to Move to new location
     * @param cell
     * @return
     */
    boolean isPossibleToGoTo(Cell cell);

    /**
     * Where is this chessman can go (based on chess rules)
     * @return list of destinations
     */
    Collection<Coordinate> possibleMovements();

}
