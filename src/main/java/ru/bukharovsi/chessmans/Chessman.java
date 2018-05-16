package ru.bukharovsi.chessmans;


import ru.bukharovsi.Cell;
import ru.bukharovsi.Coordinate;

import java.util.Collection;

/**
 * A shape of chess.
 * Can be a king, queen, pawn and so on.
 * Of course, has a Colour and position. Also can goto another cell, hack another chessman.
 */
public interface Chessman {

    Cell.Colour colour();

    void goTo(Cell cell);

    void hackTo(Cell cell);

    void killed();

    boolean isPossibleToGoTo(Cell cell);

    boolean isPossibleToHackTo(Cell cell);

    boolean possibleToMove(Coordinate to);

    Collection<Coordinate> possibleMovements();

}
