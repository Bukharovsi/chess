package ru.bukharovsi;

import ru.bukharovsi.exceptions.BoardAccessException;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents game board with black and white cells
 * Allows to pick a Cell
 */
public class ChessBoard {

    private Map<Coordinate, Cell> board = new HashMap<>();

    public ChessBoard() {
        fillCells();
    }

    private void fillCells() {
        for (int currentInt : Coordinate.VERTICAL_NAMES) {

            Colour lineStartWith;
            if (currentInt % 2 == 0)  {
                lineStartWith = Colour.WHITE;
            } else {
                lineStartWith = Colour.BLACK;
            }

            Colour previousColour = lineStartWith.invert();
            for (Character currenChar : Coordinate.HORIZONTAL_NAMES) {
                Coordinate coordinate = new Coordinate(currenChar, currentInt);

                Colour currentColour = previousColour.invert();
                board.put(coordinate, new Cell(coordinate, currentColour));
                previousColour = currentColour;
            }
        }
    }



    public Cell cell(Coordinate coordinate) {
        if (! board.containsKey(coordinate)) {
            throw BoardAccessException.cellNotExists(coordinate, this);
        }
        return board.get(coordinate);
    }

    public Cell cell(String coupleOfCoordinates) {
        return cell(Coordinate.at(coupleOfCoordinates));
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Board is \n");
        board.values().stream().sorted().forEach(cell -> str.append(cell).append("\n"));
        return str.toString();
    }
}
