package ru.bukharovsi.chess.domains.exceptions;

import ru.bukharovsi.chess.domains.field.Cell;

public class CantRemoveOccupantBecauseCellIsEmpty extends RuntimeException {
    public CantRemoveOccupantBecauseCellIsEmpty(Cell cell) {
        super(String.format("Cant remove occupant because cell %s is empty", cell.toString()));
    }
}
