package ru.bukharovsi.chessmans;

import ru.bukharovsi.Cell;
import ru.bukharovsi.Colour;
import ru.bukharovsi.rules.moveRules.MoveForwardTwoSteps;
import ru.bukharovsi.rules.moveRules.MoveForwardOneStepRule;

public class Pawn extends AbstractChessman {

    public Pawn(Colour colour, Cell standAt) {
        super(colour, standAt, new MoveForwardTwoSteps());
    }

    @Override
    public void goTo(Cell cell) {
        super.goTo(cell);
        moveRules = new MoveForwardOneStepRule();
    }

    @Override
    public void hackTo(Cell cell) {
        super.hackTo(cell);
        moveRules = new MoveForwardOneStepRule();
    }

    @Override
    public boolean isPossibleToGoTo(Cell cell) {
        return !cell.isOccupaied() && possibleToMove(cell.coordinate());
    }

    @Override
    public boolean isPossibleToHackTo(Cell cell) {
        return cell.isOccupaied() && possibleToMove(cell.coordinate());
    }


    @Override
    public String toString() {
        return colour() + " Pawn";
    }
}
