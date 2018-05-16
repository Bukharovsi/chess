package ru.bukharovsi.exceptions;

import ru.bukharovsi.Cell;
import ru.bukharovsi.chessmans.AbstractChessman;
import ru.bukharovsi.chessmans.Chessman;

public class ChessmanHackException extends RuntimeException {

    public ChessmanHackException(String message) {
        super(message);
    }

    public static ChessmanHackException cellNotOccupied(Chessman chessman, Cell hackTo) {
        return new ChessmanHackException(
                String.format(" %s can`t hack to %s, because cell is not occipied", chessman, hackTo)
        );
    }

    public static ChessmanHackException cellOccupantHasTheSameColour(Chessman chessman, Cell cell) {
        return new ChessmanHackException(
                String.format("%s cant hack to %s because cell occupant has the same colour", chessman, cell)
        );
    }
}
