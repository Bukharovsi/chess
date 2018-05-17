package ru.bukharovsi.chess.domains.chessmans;

import ru.bukharovsi.chess.domains.Colour;
import ru.bukharovsi.chess.domains.field.Cell;
import ru.bukharovsi.chess.domains.rules.moveRules.MoveOneStepAnyDirectionRule;

public class King extends AbstractChessman {

    public King(Colour colour, Cell standAt) {
        super(
                colour,
                standAt,
                new MoveOneStepAnyDirectionRule()
        );
    }

    @Override
    public String toString() {
        return colour() + " King";
    }
}
