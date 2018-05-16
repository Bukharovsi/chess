package ru.bukharovsi.rules.moveRules;

import ru.bukharovsi.Coordinate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MoveVerticalToBoarder implements MoveRules {

    @Override
    public boolean possibleToMove(Coordinate from, Coordinate to) {
        return false;
    }

    @Override
    public Collection<Coordinate> possibleMovementsFrom(Coordinate from) {
        List<Coordinate> possibleMovements = new ArrayList<>();
        possibleMovements.addAll(collectUp(from));
        possibleMovements.addAll(collectDown(from));
        return possibleMovements;
    }

    private Collection<Coordinate> collectUp(Coordinate from) {
        List<Coordinate> posibleMovements = new ArrayList<>();
        Coordinate currentPosition = from;
        while (currentPosition.possibleToMoveUp()) {
            currentPosition = currentPosition.moveUp();
            posibleMovements.add(currentPosition);
        }

        return posibleMovements;
    }

    private Collection<Coordinate> collectDown(Coordinate from) {
        List<Coordinate> posibleMovements = new ArrayList<>();
        Coordinate currentPosition = from;
        while (currentPosition.possibleToMoveDown()) {
            currentPosition = currentPosition.moveDown();
            posibleMovements.add(currentPosition);
        }

        return posibleMovements;
    }
}
