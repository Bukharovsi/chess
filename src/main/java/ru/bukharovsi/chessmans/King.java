package ru.bukharovsi.chessmans;

import ru.bukharovsi.Cell;
import ru.bukharovsi.rules.moveRules.*;

public class King extends AbstractChessman {

    public King(Cell.Colour colour, Cell standAt) {
        super(
                colour,
                standAt,
                new MoveOneStepAnyDirection()
        );
    }

    @Override
    public boolean isPossibleToGoTo(Cell cell) {
        return possibleToMove(cell.coordinate());
    }

    @Override
    public boolean isPossibleToHackTo(Cell cell) {
        return cell.isOccupaied() && possibleToMove(cell.coordinate());
    }

    @Override
    public String toString() {
        return colour() + " King";
    }
}
