package ru.bukharovsi.rules.moveRules;

import ru.bukharovsi.Coordinate;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * | * | * | * | 1
 * | * | I | * | 2
 * | X | * | X | 3
 * | * | * | * | 4
 *   A   B   C
 *
 *   I - from
 *   X - destination
 */
public class MoveOneStepDiagonalDownRule extends AbstractMoveRule {

    @Override
    public Collection<Coordinate> possibleMovementsFrom(Coordinate from) {
        Set<Coordinate> possibleDestinations = new HashSet<>();

        if (from.possibleToMoveRightDown()) possibleDestinations.add(from.moveRightDown());
        if (from.possibleToMoveLeftDown()) possibleDestinations.add(from.moveLeftDown());

        return possibleDestinations;
    }
}
