package ru.bukharovsi.chess.domains.rules.moveRules;

import ru.bukharovsi.chess.domains.field.Coordinate;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class MoveDiagonalRule extends AbstractMoveRule {

    @Override
    public Collection<Coordinate> possibleMovementsFrom(Coordinate from) {
        Set<Coordinate> possibleMovements = new HashSet<>();

        Coordinate current = from;
        while (current.possibleToMoveLeftUp()) {
            possibleMovements.add(current = current.moveLeftUp());
        }

        current = from;
        while (current.possibleToMoveLeftDown()) {
            possibleMovements.add(current = current.moveLeftDown());
        }

        current = from;
        while (current.possibleToMoveRightUp()) {
            possibleMovements.add(current = current.moveRightUp());
        }

        current = from;
        while (current.possibleToMoveRightDown()) {
            possibleMovements.add(current = current.moveRightDown());
        }

        return possibleMovements;
    }
}
