package ru.bukharovsi;

import ru.bukharovsi.chessmans.Chessman;
import ru.bukharovsi.exceptions.CantGetAOccupantBecauseCellIsEmpty;
import ru.bukharovsi.exceptions.CantRemoveOccupantBecauseCellIsEmpty;
import ru.bukharovsi.exceptions.CellIsOccupiedException;

import java.util.Optional;

public class Cell {

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

    @Override
    public String toString() {
        String occupantStr = occupant.map(chessman -> "Occupaied by " + chessman.toString()).orElse("is empty");

        return colour.toString() + " " + coordinate.toString() + " " + occupantStr;
    }

    enum Colour {
        BLACK,
        WHITE;
    }
}
