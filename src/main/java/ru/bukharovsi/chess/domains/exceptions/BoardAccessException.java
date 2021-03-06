package ru.bukharovsi.chess.domains.exceptions;

import ru.bukharovsi.chess.domains.field.ChessBoard;
import ru.bukharovsi.chess.domains.field.Coordinate;

public class BoardAccessException extends RuntimeException {

    public BoardAccessException(String message) {
        super(message);
    }

    public static BoardAccessException cellNotExists(Coordinate coordinate, ChessBoard chessBoard) {
        return new BoardAccessException(String.format("Cell %s not exists in board %s", coordinate, chessBoard));
    }
}
