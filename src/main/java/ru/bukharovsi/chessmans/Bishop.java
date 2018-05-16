package ru.bukharovsi.chessmans;

import ru.bukharovsi.Cell;
import ru.bukharovsi.rules.moveRules.MoveDiagonalRule;

public class Bishop extends AbstractChessman {

    public Bishop(Cell.Colour colour, Cell standAt) {
        super(colour, standAt, new MoveDiagonalRule());
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
        return colour() + " Bishop";
    }
}