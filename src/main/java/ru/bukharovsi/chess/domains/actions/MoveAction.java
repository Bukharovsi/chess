package ru.bukharovsi.chess.domains.actions;

import ru.bukharovsi.chess.domains.chessmans.Chessman;
import ru.bukharovsi.chess.domains.exceptions.ChessmanMovementException;
import ru.bukharovsi.chess.domains.field.Cell;

/**
 * represents move action based on chess rules
 */
public class MoveAction {

    public boolean isPossibleToMove(Chessman chessman, Cell destination) {
        try {
            checkMoveTo(chessman, destination);
        } catch (Exception exception) {
            return false;
        }

        return true;
    }

    public void moveTo(Cell from, Cell destination) {
        checkMoveTo(from.getOccupant(), destination);

        Chessman chessman = from.removeOccupant();
        destination.occupy(chessman);
    }

    private void checkMoveTo(Chessman chessman, Cell destination) {
        if (! chessman.isPossibleToGoTo(destination)) {
            throw ChessmanMovementException.cantMoveToCell(chessman, destination);
        }

        if (destination.isOccupaied()) {
            throw ChessmanMovementException.cellIsOccupied(chessman, destination);
        }

    }
}
