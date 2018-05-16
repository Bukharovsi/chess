package ru.bukharovsi.chessmans;

import ru.bukharovsi.Cell;
import ru.bukharovsi.Coordinate;
import ru.bukharovsi.exceptions.ChessmanMovementException;
import ru.bukharovsi.rules.MoveRules;

import java.util.Collection;

public abstract class AbstractChessman implements Chessman {

    private Cell.Colour colour;

    private Cell standAt;

    protected MoveRules rules;

    public AbstractChessman(Cell.Colour colour, Cell standAt, MoveRules rules) {
        this.colour = colour;
        this.standAt = standAt;
        this.rules = rules;
    }

    @Override
    public Cell.Colour colour() {
        return colour;
    }

    @Override
    public void goTo(Cell cell) {
        if (! possibleToMove(cell.coordinate())) {
            throw new ChessmanMovementException("ololo");
        }
        standAt.removeOccupant();
        cell.occupy(this);
    }

    @Override
    public void hackTo(Cell cell) {
        cell.removeOccupant();
        cell.occupy(this);
    }

    public Cell standAt() {
        return standAt;
    }

    @Override
    public boolean possibleToMove(Coordinate to) {
        return rules.possibleToMove(standAt().coordinate(), to);
    }

    @Override
    public Collection<Coordinate> possibleMovements() {
        return rules.possibleMovementsFrom(standAt().coordinate());
    }
}
