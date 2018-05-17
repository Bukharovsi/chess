package ru.bukharovsi.chess.domains.rules.moveRules;

import ru.bukharovsi.chess.domains.field.Coordinate;

import java.util.Collection;

/**
 * Defined cells allow to move to.
 * It defines basic chess movement rules
 */
public interface MoveRule {

    /**
     * Is it possible to move from one cell to another
     * @param from current cell
     * @param to destination
     * @return true is possible, false otherwise
     */
    boolean possibleToMove(Coordinate from, Coordinate to);

    /**
     * Get possible destination for this rule
     * @param from current cell
     * @return possible destinations
     */
    Collection<Coordinate> possibleMovementsFrom(Coordinate from);
}
