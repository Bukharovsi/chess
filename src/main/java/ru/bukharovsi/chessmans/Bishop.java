package ru.bukharovsi.chessmans;

import ru.bukharovsi.Cell;
import ru.bukharovsi.Colour;
import ru.bukharovsi.rules.moveRules.MoveDiagonalRule;

public class Bishop extends AbstractChessman {

    public Bishop(Colour colour, Cell standAt) {
        super(colour, standAt, new MoveDiagonalRule());
    }

    @Override
    public String toString() {
        return colour() + " Bishop";
    }
}
