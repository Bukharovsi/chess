package ru.bukharovsi.chess.domains.rules.moveRules;

import ru.bukharovsi.chess.domains.field.Coordinate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MoveHorizontalToBoarderRule extends AbstractMoveRule {

    @Override
    public boolean possibleToMove(Coordinate from, Coordinate to) {
        return false;
    }

    @Override
    public Collection<Coordinate> possibleMovementsFrom(Coordinate from) {
        List<Coordinate> possibleMovements = new ArrayList<>();
        possibleMovements.addAll(collectRight(from));
        possibleMovements.addAll(collectLeft(from));
        return possibleMovements;
    }

    private Collection<Coordinate> collectRight(Coordinate from) {
        List<Coordinate> posibleMovements = new ArrayList<>();
        Coordinate currentPosition = from;
        while (currentPosition.possibleToMoveRight()) {
            currentPosition = currentPosition.moveRight();
            posibleMovements.add(currentPosition);
        }

        return posibleMovements;
    }

    private Collection<Coordinate> collectLeft(Coordinate from) {
        List<Coordinate> posibleMovements = new ArrayList<>();
        Coordinate currentPosition = from;
        while (currentPosition.possibleToMoveLeft()) {
            currentPosition = currentPosition.moveLeft();
            posibleMovements.add(currentPosition);
        }

        return posibleMovements;
    }
}
