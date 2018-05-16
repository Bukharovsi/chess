package ru.bukharovsi.chessmans;

import ru.bukharovsi.Cell;
import ru.bukharovsi.Colour;
import ru.bukharovsi.rules.moveRules.*;

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
