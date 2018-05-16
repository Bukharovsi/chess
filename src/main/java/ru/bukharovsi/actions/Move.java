package ru.bukharovsi.actions;

import ru.bukharovsi.Cell;
import ru.bukharovsi.chessmans.Chessman;

/**
 * Represents a move from cell to cell
 */
public class Move {

    private final Chessman chessman;
    private final Cell from;
    private final Cell destination;

    public Move(Chessman chessman, Cell from, Cell destination) {
        this.chessman = chessman;
        this.from = from;
        this.destination = destination;
    }
}
