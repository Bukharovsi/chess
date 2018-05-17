package ru.bukharovsi.chess.domains.rules.moveRules;

import ru.bukharovsi.chess.domains.field.Coordinate;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class MoveOneStepAnyDirectionRule extends AbstractMoveRule {

    @Override
    public Collection<Coordinate> possibleMovementsFrom(Coordinate from) {
        Set<Coordinate> possibleDestinations = new HashSet<>();

        if (from.possibleToMoveUp()) possibleDestinations.add(from.moveUp());
        if (from.possibleToMoveDown()) possibleDestinations.add(from.moveDown());
        if (from.possibleToMoveRight()) possibleDestinations.add(from.moveRight());
        if (from.possibleToMoveLeft()) possibleDestinations.add(from.moveLeft());
        if (from.possibleToMoveRightUp()) possibleDestinations.add(from.moveRightUp());
        if (from.possibleToMoveRightDown()) possibleDestinations.add(from.moveRightDown());
        if (from.possibleToMoveLeftUp()) possibleDestinations.add(from.moveLeftUp());
        if (from.possibleToMoveLeftDown()) possibleDestinations.add(from.moveLeftDown());

        return possibleDestinations;
    }
}
