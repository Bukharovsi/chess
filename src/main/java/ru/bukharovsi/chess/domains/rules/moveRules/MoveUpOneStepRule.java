package ru.bukharovsi.chess.domains.rules.moveRules;

import ru.bukharovsi.chess.domains.field.Coordinate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Pawn can go only forward
 */
public class MoveUpOneStepRule extends AbstractMoveRule {

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
