package ru.bukharovsi.exceptions;


import ru.bukharovsi.Cell;
import ru.bukharovsi.chessmans.Chessman;

public class CellIsOccupiedException extends RuntimeException {
    public CellIsOccupiedException(Cell occupaiedCell, Chessman occupant) {
        super(String.format(
                "You can put chessman to Cell %s, because it is occupied by %s",
                occupaiedCell.toString(),
                occupant.toString())
        );
    }
}
