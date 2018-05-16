package ru.bukharovsi.rules.moveRules;

import ru.bukharovsi.Coordinate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * In first turn Pawn can go forward 2 times
 */
public class MoveUpTwoStepsRule extends AbstractMoveRule {

    @Override
    public Collection<Coordinate> possibleMovementsFrom(Coordinate from) {
        List<Coordinate> moves = new ArrayList<>();

        // move forward
        if (from.possibleToMoveUp()) {
            moves.add(from.moveUp());
        }

        // move forward 2 steps
        if (from.possibleToMoveUp() && from.moveUp().possibleToMoveUp()) {
            moves.add(from.moveUp().moveUp());
        }

        return moves;
    }
}
