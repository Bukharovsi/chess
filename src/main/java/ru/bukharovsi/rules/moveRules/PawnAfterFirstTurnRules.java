package ru.bukharovsi.rules.moveRules;

import ru.bukharovsi.Coordinate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Pawn can go only forward
 */
public class PawnAfterFirstTurnRules implements MoveRules {

    @Override
    public boolean possibleToMove(Coordinate from, Coordinate to) {
        return possibleMovementsFrom(from).contains(to);
    }

    @Override
    public Collection<Coordinate> possibleMovementsFrom(Coordinate from) {
        List<Coordinate> moves = new ArrayList<>();

        // move forward
        if (from.possibleToMoveUp()) {
            moves.add(from.moveUp());
        }

        return moves;
    }
}
