package ru.bukharovsi.exceptions;

import ru.bukharovsi.Cell;

public class CantRemoveOccupantBecauseCellIsEmpty extends RuntimeException {
    public CantRemoveOccupantBecauseCellIsEmpty(Cell cell) {
        super(String.format("Cant remove occupant because cell %s is empty", cell.toString()));
    }
}
