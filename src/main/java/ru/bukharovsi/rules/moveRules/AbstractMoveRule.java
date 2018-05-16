package ru.bukharovsi.rules.moveRules;

import ru.bukharovsi.Coordinate;

abstract class AbstractMoveRule implements MoveRule {

    @Override
    public boolean possibleToMove(Coordinate from, Coordinate to) {
        return possibleMovementsFrom(from).contains(to);
    }
}
