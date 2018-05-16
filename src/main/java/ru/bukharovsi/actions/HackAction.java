package ru.bukharovsi.actions;

import ru.bukharovsi.Cell;
import ru.bukharovsi.chessmans.Chessman;
import ru.bukharovsi.exceptions.ChessmanHackException;
import ru.bukharovsi.exceptions.ChessmanMovementException;

public class HackAction {

    public boolean isPossibleToHack(Chessman killer, Cell destination) {
        try {
            checkHackTo(killer, destination);
        } catch (Exception exception) {
            return false;
        }

        return true;
    }

    public void hackTo(Chessman killer, Cell destination) {
        checkHackTo(killer, destination);

        Chessman killedOccupant = destination.removeOccupant();
        killedOccupant.killed();
        destination.occupy(killer);
    }

    private void checkHackTo(Chessman killer, Cell destination) {
        if (! killer.possibleToMove(destination.coordinate())) {
            throw ChessmanMovementException.cantMoveToCell(killer, destination);
        }

        if (! destination.isOccupaied()) {
            throw ChessmanHackException.cellNotOccupied(killer, destination);
        }

        if (destination.getOccupant().colour().equals(killer.colour())) {
            throw ChessmanHackException.cellOccupantHasTheSameColour(killer, destination);
        }
    }
}
