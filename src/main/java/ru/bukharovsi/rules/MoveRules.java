package ru.bukharovsi.rules;

import ru.bukharovsi.Coordinate;

import java.util.Collection;

public interface MoveRules {
    boolean possibleToMove(Coordinate from, Coordinate to);

    Collection<Coordinate> possibleMovementsFrom(Coordinate from);
}
