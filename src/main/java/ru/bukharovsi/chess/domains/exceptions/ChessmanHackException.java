package ru.bukharovsi.chess.domains.exceptions;

import ru.bukharovsi.chess.domains.chessmans.Chessman;
import ru.bukharovsi.chess.domains.field.Cell;

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
