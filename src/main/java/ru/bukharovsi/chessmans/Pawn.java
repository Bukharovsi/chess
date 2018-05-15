package ru.bukharovsi.chessmans;

import ru.bukharovsi.Cell;
import ru.bukharovsi.Coordinate;

import java.util.Collection;

public class Pawn implements Chessman {

    private Cell.Colour colour;

    private Cell standAt;

    public Pawn(Cell.Colour colour, Cell standAt) {
        this.colour = colour;
        this.standAt = standAt;
    }

    @Override
    public Cell.Colour colour() {
        return colour;
    }

    @Override
    public void goTo(Cell cell) {

    }

    @Override
    public void hackTo(Cell cell) {

    }

    @Override
    public boolean isPossibleToGoTo(Cell cell) {
        return false;
    }

    @Override
    public boolean isPossibleToHackTo(Cell cell) {
        return false;
    }

    @Override
    public Collection<Cell> possibleMovements() {
        return null;
    }
}
