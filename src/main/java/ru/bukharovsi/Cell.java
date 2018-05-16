package ru.bukharovsi;

import ru.bukharovsi.chessmans.Chessman;
import ru.bukharovsi.exceptions.CantGetAOccupantBecauseCellIsEmpty;
import ru.bukharovsi.exceptions.CantRemoveOccupantBecauseCellIsEmpty;
import ru.bukharovsi.exceptions.CellIsOccupiedException;

import java.util.Optional;

/**
 * Represents a one cell of chessboard.
 * Has a coordinate like E5, D4, also has a colour (black or white)
 * Can be occupied by chessman.
 */
public class Cell implements Comparable<Cell> {

    private Colour colour;

    private Optional<Chessman> occupant;

    private Coordinate coordinate;

    public Cell(Coordinate coordinate, Colour colour) {
        this.colour = colour;
        this.coordinate = coordinate;
        occupant = Optional.empty();
    }

    /**
     * Move chessman to this cell
     * @param newChessman occupant
     */
    public void occupy(Chessman newChessman) {
        if (occupant.isPresent()) {
            throw new CellIsOccupiedException(this, occupant.get());
        }

        occupant = Optional.of(newChessman);
    }

    /**
     * there is a chessman on the cell?
     * @return true if occupaied else otherwise
     */
    public boolean isOccupaied() {
        return occupant.isPresent();
    }

    /**
     * get a chessman stands on the cell
     * @return
     */
    public Chessman getOccupant() {
        return occupant.orElseThrow(() -> new CantGetAOccupantBecauseCellIsEmpty(this));
    }

    /**
     * move occupant from the cell
     * @return
     */
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

}
