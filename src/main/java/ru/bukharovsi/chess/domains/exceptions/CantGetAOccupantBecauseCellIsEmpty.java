package ru.bukharovsi.chess.domains.exceptions;

import ru.bukharovsi.chess.domains.field.Cell;

public class CantGetAOccupantBecauseCellIsEmpty extends RuntimeException {
    public CantGetAOccupantBecauseCellIsEmpty(Cell emptyCell) {
        super(String.format("Cant get a occupant because cell %s is empty", emptyCell));
    }
}
