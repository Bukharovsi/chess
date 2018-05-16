package ru.bukharovsi.chessmans;

import lombok.extern.slf4j.Slf4j;
import ru.bukharovsi.Cell;
import ru.bukharovsi.Colour;
import ru.bukharovsi.Coordinate;
import ru.bukharovsi.exceptions.ChessmanMovementException;
import ru.bukharovsi.actions.HackAction;
import ru.bukharovsi.rules.moveRules.MoveRule;

import java.util.Collection;

@Slf4j
public abstract class AbstractChessman implements Chessman {

    private Colour colour;

    private Cell standAt;

    protected MoveRule moveRule;

    protected HackAction hackAction;

    public AbstractChessman(Colour colour, Cell standAt, MoveRule moveRule, HackAction hackAction) {
        this.colour = colour;
        this.standAt = standAt;
        this.moveRule = moveRule;
        this.hackAction = hackAction;
    }

    public AbstractChessman(Colour colour, Cell standAt, MoveRule moveRule) {
        this(colour, standAt, moveRule, new HackAction());
    }

    @Override
    public Colour colour() {
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
        hackAction.hackTo(this, cell);
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
        return moveRule.possibleToMove(standAt().coordinate(), to);
    }

    @Override
    public Collection<Coordinate> possibleMovements() {
        return moveRule.possibleMovementsFrom(standAt().coordinate());
    }
}
