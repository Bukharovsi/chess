package ru.bukharovsi.chess.domains.chessmans;

import ru.bukharovsi.chess.domains.Colour;
import ru.bukharovsi.chess.domains.field.Cell;
import ru.bukharovsi.chess.domains.rules.moveRules.AggregateRule;
import ru.bukharovsi.chess.domains.rules.moveRules.MoveHorizontalToBoarderRule;
import ru.bukharovsi.chess.domains.rules.moveRules.MoveVerticalToBoarderRule;

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
