package ru.bukharovsi.rules.moveRules;

import ru.bukharovsi.Coordinate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * In first turn Pawn can go forward 2 times
 */
public class MoveDownTwoStepsRule extends AbstractMoveRule {

    @Override
    public Collection<Coordinate> possibleMovementsFrom(Coordinate from) {
        List<Coordinate> moves = new ArrayList<>();

        // move forward
        if (from.possibleToMoveDown()) {
            moves.add(from.moveDown());
        }

        // move forward 2 steps
        if (from.possibleToMoveDown() && from.moveDown().possibleToMoveDown()) {
            moves.add(from.moveDown().moveDown());
        }

        return moves;
    }
}
