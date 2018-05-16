package ru.bukharovsi.actions;

import ru.bukharovsi.Cell;
import ru.bukharovsi.chessmans.Chessman;
import ru.bukharovsi.exceptions.ChessmanHackException;
import ru.bukharovsi.exceptions.ChessmanMovementException;

/**
 * represents move action based on chess rules
 */
public class MoveAction {

    public boolean isPossibleToMove(Chessman chessman, Cell destination) {
        try {
            checMoveTo(chessman, destination);
        } catch (Exception exception) {
            return false;
        }

        return true;
    }

    public void moveTo(Cell from, Cell destination) {
        checMoveTo(from.getOccupant(), destination);

        Chessman chessman = from.removeOccupant();
        destination.occupy(chessman);
    }

    private void checMoveTo(Chessman chessman, Cell destination) {
        if (! chessman.isPossibleToGoTo(destination)) {
            throw ChessmanMovementException.cantMoveToCell(chessman, destination);
        }

        if (destination.isOccupaied()) {
            throw ChessmanMovementException.cellIsOccupied(chessman, destination);
        }

    }
}
