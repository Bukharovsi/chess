package ru.bukharovsi.chessmans;

import ru.bukharovsi.Cell;
import ru.bukharovsi.Colour;
import ru.bukharovsi.rules.moveRules.AggregateRule;
import ru.bukharovsi.rules.moveRules.MoveDiagonalRule;
import ru.bukharovsi.rules.moveRules.MoveHorizontalToBoarder;
import ru.bukharovsi.rules.moveRules.MoveVerticalToBoarder;

public class Queen extends AbstractChessman {

    public Queen(Colour colour, Cell standAt) {
        super(
                colour,
                standAt,
                new AggregateRule()
                    .addRule(new MoveHorizontalToBoarder())
                    .addRule(new MoveVerticalToBoarder())
                    .addRule(new MoveDiagonalRule())
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
        return colour() + " Queen";
    }
}
