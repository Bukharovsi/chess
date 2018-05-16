package ru.bukharovsi.exceptions;

import ru.bukharovsi.Cell;
import ru.bukharovsi.chessmans.Chessman;

public class ChessmanMovementException extends RuntimeException {

    public ChessmanMovementException(String message) {
        super(message);
    }

    public static ChessmanMovementException cantMoveToCell(Chessman chessman, Cell moveToCell) {
        return new ChessmanMovementException(String.format(
                "There is not possible to %s to move to cell %s", chessman, moveToCell));
    }

    public static ChessmanMovementException cellIsOccupied(Chessman chessman, Cell destination) {
        return new ChessmanMovementException(String.format(
                "There is not possible to %s to move to cell %s because cell is occupied", chessman, destination));
    }
}
