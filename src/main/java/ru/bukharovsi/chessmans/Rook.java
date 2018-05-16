package ru.bukharovsi.chessmans;

import ru.bukharovsi.Cell;
import ru.bukharovsi.Colour;
import ru.bukharovsi.rules.moveRules.AggregateRule;
import ru.bukharovsi.rules.moveRules.MoveHorizontalToBoarderRule;
import ru.bukharovsi.rules.moveRules.MoveVerticalToBoarderRule;

public class Rook extends AbstractChessman {

    public Rook(Colour colour, Cell standAt) {
        super(
                colour,
                standAt,
                new AggregateRule()
                        .addRule(new MoveHorizontalToBoarderRule())
                        .addRule(new MoveVerticalToBoarderRule())
        );
    }


    @Override
    public String toString() {
        return colour() + " Rook";
    }

}
