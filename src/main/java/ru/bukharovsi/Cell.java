package ru.bukharovsi;

import ru.bukharovsi.chessmans.Chessman;
import ru.bukharovsi.exceptions.CantGetAOccupantBecauseCellIsEmpty;
import ru.bukharovsi.exceptions.CantRemoveOccupantBecauseCellIsEmpty;
import ru.bukharovsi.exceptions.CellIsOccupiedException;

import java.util.Optional;

public class Cell implements Comparable<Cell> {

    private Colour colour;

    private Optional<Chessman> occupant;

    private Coordinate coordinate;

    public Cell(Coordinate coordinate, Colour colour) {
        this.colour = colour;
        this.coordinate = coordinate;
        occupant = Optional.empty();
    }

    public void occupy(Chessman newChessman) {
        if (occupant.isPresent()) {
            throw new CellIsOccupiedException(this, occupant.get());
        }

        occupant = Optional.of(newChessman);
    }

    public boolean isOccupaied() {
        return occupant.isPresent();
    }

    public Chessman getOccupant() {
        return occupant.orElseThrow(() -> new CantGetAOccupantBecauseCellIsEmpty(this));
    }

    public Chessman removeOccupant() {
        if (! occupant.isPresent()) {
            throw new CantRemoveOccupantBecauseCellIsEmpty(this);
        }

        Chessman removedOccupant = occupant.get();
        occupant = Optional.empty();
        return removedOccupant;
    }

    public Colour colour() {
        return colour;
    }

    public Coordinate coordinate() {
        return coordinate;
    }

    @Override
    public int compareTo(Cell anotherCell) {
        return this.coordinate.compareTo(anotherCell.coordinate);
    }

    @Override
    public String toString() {
        String occupantStr = occupant.map(chessman -> "Occupaied by " + chessman.toString()).orElse("is empty");

        return coordinate.toString() + " " + colour.toString() + " "  + occupantStr;
    }

    public enum Colour {
        BLACK,
        WHITE;

        public Colour invert() {
            if (this == BLACK) return WHITE;else return BLACK;
        }

        public boolean isBlack() {
            return this == BLACK;
        }

        public boolean isWhite() {
            return this == WHITE;
        }
    }
}
