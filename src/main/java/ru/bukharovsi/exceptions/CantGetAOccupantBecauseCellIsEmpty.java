package ru.bukharovsi.exceptions;

import ru.bukharovsi.Cell;

public class CantGetAOccupantBecauseCellIsEmpty extends RuntimeException {
    public CantGetAOccupantBecauseCellIsEmpty(Cell emptyCell) {
        super(String.format("Cant get a occupant because cell %s is empty", emptyCell));
    }
}
