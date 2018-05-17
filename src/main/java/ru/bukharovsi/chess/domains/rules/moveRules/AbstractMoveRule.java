package ru.bukharovsi.chess.domains.rules.moveRules;

import ru.bukharovsi.chess.domains.field.Coordinate;

abstract class AbstractMoveRule implements MoveRule {

    @Override
    public boolean possibleToMove(Coordinate from, Coordinate to) {
        return possibleMovementsFrom(from).contains(to);
    }
}
