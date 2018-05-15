package ru.bukharovsi;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ChessBoard {

    private Map<Coordinate, Cell> board = new HashMap<>();

    public ChessBoard() {
        for (int currentInt : Coordinate.Y_COORDINATES) {

            Cell.Colour lineStartWith;
            if (currentInt % 2 == 0)  {
                lineStartWith = Cell.Colour.WHITE;
            } else {
                lineStartWith = Cell.Colour.BLACK;
            }

            Cell.Colour previousColour = lineStartWith.invert();
            for (Character currenChar : Coordinate.X_COORDINATES.toCharArray()) {
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

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Board is \n");
        board.values().stream().sorted().forEach(cell -> str.append(cell).append("\n"));
        return str.toString();
    }
}
