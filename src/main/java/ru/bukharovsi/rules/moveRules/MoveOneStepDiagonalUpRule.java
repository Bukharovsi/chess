package ru.bukharovsi.rules.moveRules;

import ru.bukharovsi.Coordinate;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * | * | * | * | 1
 * | X | * | X | 2
 * | * | I | * | 3
 * | * | * | * | 4
 *   A   B   C
 *
 *   I - from
 *   X - destination
 */
public class MoveOneStepDiagonalUpRule extends AbstractMoveRule {

    @Override
    public Collection<Coordinate> possibleMovementsFrom(Coordinate from) {
        Set<Coordinate> possibleDestinations = new HashSet<>();

        if (from.possibleToMoveRightUp()) possibleDestinations.add(from.moveRightUp());
        if (from.possibleToMoveLeftUp()) possibleDestinations.add(from.moveLeftUp());

        return possibleDestinations;
    }
}
