package ru.bukharovsi.chess.domains.actions;

import ru.bukharovsi.chess.domains.chessmans.Chessman;
import ru.bukharovsi.chess.domains.exceptions.ChessmanHackException;
import ru.bukharovsi.chess.domains.exceptions.ChessmanMovementException;
import ru.bukharovsi.chess.domains.field.Cell;

/**
 * Represents a rule how to hack a chessman
 * Basic rules are
 *  - you cant hack your own chessman
 *  - you can hack another chessman if you can to move anu your chessman to the attacked chessman
 */
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
        killedOccupant.killedBy(killer);
        destination.occupy(killer);
    }

    private void checkHackTo(Chessman killer, Cell destination) {
        if (! killer.isPossibleToGoTo(destination)) {
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
