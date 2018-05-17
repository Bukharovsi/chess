package ru.bukharovsi.chess.domains.chessmans;

import lombok.extern.slf4j.Slf4j;
import ru.bukharovsi.chess.domains.Colour;
import ru.bukharovsi.chess.domains.actions.HackAction;
import ru.bukharovsi.chess.domains.actions.MoveAction;
import ru.bukharovsi.chess.domains.exceptions.ChessmanMovementException;
import ru.bukharovsi.chess.domains.field.Cell;
import ru.bukharovsi.chess.domains.field.Coordinate;
import ru.bukharovsi.chess.domains.rules.moveRules.MoveRule;

import java.util.Collection;

@Slf4j
public abstract class AbstractChessman implements Chessman {

    private Colour colour;

    private Cell standAt;

    protected MoveRule moveRule;

    protected HackAction hackAction;

    protected MoveAction moveAction;

    private Boolean isAlive;

    public AbstractChessman(Colour colour, Cell standAt, MoveRule moveRule, HackAction hackAction, MoveAction moveAction) {
        this.colour = colour;
        this.standAt = standAt;
        this.moveRule = moveRule;
        this.hackAction = hackAction;
        this.moveAction = moveAction;
        this.isAlive = true;
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
        standAt = null;
        isAlive = false;
    }

    @Override
    public boolean isAlive() {
        return isAlive;
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
