package ru.bukharovsi.rules.moveRules;

import ru.bukharovsi.Coordinate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Pawn can go only forward
 */
public class MoveDownOneStepRule extends AbstractMoveRule {

    @Override
    public Collection<Coordinate> possibleMovementsFrom(Coordinate from) {
        List<Coordinate> moves = new ArrayList<>();

        // move forward
        if (from.possibleToMoveDown()) {
            moves.add(from.moveDown());
        }

        return moves;
    }
}
