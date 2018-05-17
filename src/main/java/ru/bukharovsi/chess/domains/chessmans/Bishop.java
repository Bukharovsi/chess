package ru.bukharovsi.chess.domains.chessmans;

import ru.bukharovsi.chess.domains.Colour;
import ru.bukharovsi.chess.domains.field.Cell;
import ru.bukharovsi.chess.domains.rules.moveRules.MoveDiagonalRule;

public class Bishop extends AbstractChessman {

    public Bishop(Colour colour, Cell standAt) {
        super(colour, standAt, new MoveDiagonalRule());
    }

    @Override
    public String toString() {
        return colour() + " Bishop";
    }
}
