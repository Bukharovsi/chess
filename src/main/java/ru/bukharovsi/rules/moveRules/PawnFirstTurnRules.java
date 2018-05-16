package ru.bukharovsi.rules.moveRules;

import ru.bukharovsi.Coordinate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PawnFirstTurnRules implements MoveRules {

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

        // move forward 2 steps
        if (from.possibleToMoveUp() && from.moveUp().possibleToMoveUp()) {
            moves.add(from.moveUp().moveUp());
        }

        return moves;
    }
}
