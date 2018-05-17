package ru.bukharovsi.chess.domains.exceptions;


import ru.bukharovsi.chess.domains.chessmans.Chessman;
import ru.bukharovsi.chess.domains.field.Cell;

public class CellIsOccupiedException extends RuntimeException {
    public CellIsOccupiedException(Cell occupaiedCell, Chessman occupant) {
        super(String.format(
                "You can put chessman to Cell %s, because it is occupied by %s",
                occupaiedCell.toString(),
                occupant.toString())
        );
    }
}
