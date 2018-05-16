package ru.bukharovsi;

import ru.bukharovsi.chessmans.Bishop;
import ru.bukharovsi.chessmans.Pawn;
import ru.bukharovsi.chessmans.Queen;
import ru.bukharovsi.chessmans.Rook;
import ru.bukharovsi.exceptions.BoardAccessException;

import java.util.HashMap;
import java.util.Map;

public class ChessBoard {

    private Map<Coordinate, Cell> board = new HashMap<>();

    public ChessBoard() {
        fillCells();
        putChessmen();
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

    public void putChessmen() {
        // put white pawns
        for (Character currenChar : Coordinate.HORIZONTAL_NAMES) {
            Cell currentCell = board.get(new Coordinate(currenChar, 2));
            currentCell.occupy(new Pawn(Cell.Colour.WHITE, currentCell));
        }

        // put black pawns
        for (Character currenChar : Coordinate.HORIZONTAL_NAMES) {
            Cell currentCell = board.get(new Coordinate(currenChar, 7));
            currentCell.occupy(new Pawn(Cell.Colour.BLACK, currentCell));
        }

        // add rooks
        board.get(Coordinate.at("A1")).occupy(new Rook(Cell.Colour.WHITE, board.get(Coordinate.at("A1"))));
        board.get(Coordinate.at("H1")).occupy(new Rook(Cell.Colour.WHITE, board.get(Coordinate.at("H1"))));
        board.get(Coordinate.at("A8")).occupy(new Rook(Cell.Colour.BLACK, board.get(Coordinate.at("A1"))));
        board.get(Coordinate.at("H8")).occupy(new Rook(Cell.Colour.BLACK, board.get(Coordinate.at("H8"))));

        // add bishops
        board.get(Coordinate.at("C1")).occupy(new Bishop(Cell.Colour.WHITE, board.get(Coordinate.at("C1"))));
        board.get(Coordinate.at("F1")).occupy(new Bishop(Cell.Colour.WHITE, board.get(Coordinate.at("F1"))));
        board.get(Coordinate.at("C8")).occupy(new Bishop(Cell.Colour.BLACK, board.get(Coordinate.at("C1"))));
        board.get(Coordinate.at("F8")).occupy(new Bishop(Cell.Colour.BLACK, board.get(Coordinate.at("F1"))));

        //add queens
        board.get(Coordinate.at("D1")).occupy(new Queen(Cell.Colour.WHITE, board.get(Coordinate.at("D1"))));
        board.get(Coordinate.at("D8")).occupy(new Queen(Cell.Colour.BLACK, board.get(Coordinate.at("D8"))));
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
