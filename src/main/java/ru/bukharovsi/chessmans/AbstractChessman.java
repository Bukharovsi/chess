package ru.bukharovsi.chessmans;

import lombok.extern.slf4j.Slf4j;
import ru.bukharovsi.Cell;
import ru.bukharovsi.Colour;
import ru.bukharovsi.Coordinate;
import ru.bukharovsi.actions.MoveAction;
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

    protected MoveAction moveAction;

    public AbstractChessman(Colour colour, Cell standAt, MoveRule moveRule, HackAction hackAction, MoveAction moveAction) {
        this.colour = colour;
        this.standAt = standAt;
        this.moveRule = moveRule;
        this.hackAction = hackAction;
        this.moveAction = moveAction;
    }

    public AbstractChessman(Colour colour, Cell standAt, MoveRule moveRule) {
        this(colour, standAt, moveRule, new HackAction(), new MoveAction());
    }

    @Override
    public Colour colour() {
        return colour;
    }

    @Override
    public void goTo(Cell cell) {
        if (hackAction.isPossibleToHack(this, cell)) {
            hackAction.hackTo(this, cell);
        } else if (moveAction.isPossibleToMove(this, cell)) {
            moveAction.moveTo(standAt(), cell);
        } else {
            throw ChessmanMovementException.cantMoveToCell(this, cell);
        }
    }

    public Cell standAt() {
        return standAt;
    }

    @Override
    public void killedBy(Chessman killer) {
        log.info(String.format("%s was killed by %s", this, killer));
        standAt = null; //todo need to fix!
    }

    @Override
    public boolean isPossibleToGoTo(Cell cell) {
        return possibleToMove(cell.coordinate());
    }

    protected boolean possibleToMove(Coordinate to) {
        return moveRule.possibleToMove(standAt().coordinate(), to);
    }

    @Override
    public Collection<Coordinate> possibleMovements() {
        return moveRule.possibleMovementsFrom(standAt().coordinate());
    }
}
