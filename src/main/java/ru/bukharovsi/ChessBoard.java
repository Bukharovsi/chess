package ru.bukharovsi;

import ru.bukharovsi.chessmans.*;
import ru.bukharovsi.exceptions.BoardAccessException;

import java.util.HashMap;
import java.util.Map;

public class ChessBoard {

    private Map<Coordinate, Cell> board = new HashMap<>();

    public ChessBoard() {
        fillCells();
    }

    private void fillCells() {
        for (int currentInt : Coordinate.VERTICAL_NAMES) {

            Cell.Colour lineStartWith;
            if (currentInt % 2 == 0)  {
                lineStartWith = Cell.Colour.WHITE;
            } else {
                lineStartWith = Cell.Colour.BLACK;
            }

            Cell.Colour previousColour = lineStartWith.invert();
            for (Character currenChar : Coordinate.HORIZONTAL_NAMES) {
                Coordinate coordinate = new Coordinate(currenChar, currentInt);

                Cell.Colour currentColour = previousColour.invert();
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
