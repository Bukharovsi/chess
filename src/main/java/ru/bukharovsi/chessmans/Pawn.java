package ru.bukharovsi.chessmans;

import ru.bukharovsi.Cell;
import ru.bukharovsi.Colour;
import ru.bukharovsi.Coordinate;
import ru.bukharovsi.rules.moveRules.MoveForwardRuleFactory;
import ru.bukharovsi.rules.moveRules.MoveRule;

import java.util.Collection;

public class Pawn extends AbstractChessman {

    private MoveRule hackRule;

    public Pawn(Colour colour, Cell standAt) {
        super(colour, standAt, MoveForwardRuleFactory.createTwoStepMoveRule(colour));
        hackRule = MoveForwardRuleFactory.createOneStepDForwardDiagonal(colour);
    }

    @Override
    public void goTo(Cell cell) {
        super.goTo(cell);
        moveRule = MoveForwardRuleFactory.createOneStepMoveRule(colour());
    }

    @Override
    public boolean isPossibleToGoTo(Cell cell) {
        Boolean canMove = !cell.isOccupaied() && moveRule.possibleToMove(standAt().coordinate(), cell.coordinate());
        Boolean canHack = cell.isOccupaied() && hackRule.possibleToMove(standAt().coordinate(), cell.coordinate());

        return canHack || canMove;
    }

    /**
     * Pawns can move straight, but can hack diagonal
     * @return
     */
    @Override
    public Collection<Coordinate> possibleMovements() {
        Collection<Coordinate> destinations = super.possibleMovements();
        destinations.addAll(hackRule.possibleMovementsFrom(this.standAt().coordinate()));
        return  destinations;
    }

    @Override
    public String toString() {
        return colour() + " Pawn";
    }
}
