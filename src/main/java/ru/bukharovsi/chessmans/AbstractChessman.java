package ru.bukharovsi.chessmans;

import lombok.extern.slf4j.Slf4j;
import ru.bukharovsi.Cell;
import ru.bukharovsi.Coordinate;
import ru.bukharovsi.exceptions.ChessmanHackException;
import ru.bukharovsi.exceptions.ChessmanMovementException;
import ru.bukharovsi.rules.MoveRules;

import java.util.Collection;

@Slf4j
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
            throw ChessmanMovementException.cantMoveToCell(this, cell);
        }
        standAt.removeOccupant();
        cell.occupy(this);
    }

    @Override
    public void hackTo(Cell cell) {
        if (! possibleToMove(cell.coordinate())) {
            throw ChessmanMovementException.cantMoveToCell(this, cell);
        }

        if (! cell.isOccupaied()) {
            throw ChessmanHackException.cellNotOccupied(this, cell);
        }

        if (cell.getOccupant().colour().equals(this.colour)) {
            throw ChessmanHackException.cellOccupantHasTheSameColour(this, cell);
        }

        Chessman killedOccupant = cell.removeOccupant();
        killedOccupant.killed();
        cell.occupy(this);
    }

    public Cell standAt() {
        return standAt;
    }

    @Override
    public void killed() {
        log.info(String.format("%s was killed", this));
        standAt = null; //todo need to fix!
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
