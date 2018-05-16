package ru.bukharovsi.chessmans;

import ru.bukharovsi.Cell;
import ru.bukharovsi.rules.moveRules.PawnFirstTurnRules;
import ru.bukharovsi.rules.moveRules.PawnAfterFirstTurnRules;

public class Pawn extends AbstractChessman {

    public Pawn(Cell.Colour colour, Cell standAt) {
        super(colour, standAt, new PawnFirstTurnRules());
    }

    @Override
    public void goTo(Cell cell) {
        super.goTo(cell);
        moveRules = new PawnAfterFirstTurnRules();
    }

    @Override
    public void hackTo(Cell cell) {
        super.hackTo(cell);
        moveRules = new PawnAfterFirstTurnRules();
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
