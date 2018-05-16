package ru.bukharovsi;

import ru.bukharovsi.chessmans.*;

public class ChessmanDistributor {

    private ChessBoard board;

    public ChessmanDistributor(ChessBoard gameBoard) {
        this.board = gameBoard;
    }

    public ChessBoard distributeChessmen() {
        // put white pawns
        for (Character currenChar : Coordinate.HORIZONTAL_NAMES) {
            Cell currentCell = board.cell(new Coordinate(currenChar, 2));
            currentCell.occupy(new Pawn(Cell.Colour.WHITE, currentCell));
        }

        // put black pawns
        for (Character currenChar : Coordinate.HORIZONTAL_NAMES) {
            Cell currentCell = board.cell(new Coordinate(currenChar, 7));
            currentCell.occupy(new Pawn(Cell.Colour.BLACK, currentCell));
        }

        // add rooks
        board.cell(Coordinate.at("A1")).occupy(new Rook(Cell.Colour.WHITE, board.cell(Coordinate.at("A1"))));
        board.cell(Coordinate.at("H1")).occupy(new Rook(Cell.Colour.WHITE, board.cell(Coordinate.at("H1"))));
        board.cell(Coordinate.at("A8")).occupy(new Rook(Cell.Colour.BLACK, board.cell(Coordinate.at("A1"))));
        board.cell(Coordinate.at("H8")).occupy(new Rook(Cell.Colour.BLACK, board.cell(Coordinate.at("H8"))));

        // add bishops
        board.cell(Coordinate.at("C1")).occupy(new Bishop(Cell.Colour.WHITE, board.cell(Coordinate.at("C1"))));
        board.cell(Coordinate.at("F1")).occupy(new Bishop(Cell.Colour.WHITE, board.cell(Coordinate.at("F1"))));
        board.cell(Coordinate.at("C8")).occupy(new Bishop(Cell.Colour.BLACK, board.cell(Coordinate.at("C1"))));
        board.cell(Coordinate.at("F8")).occupy(new Bishop(Cell.Colour.BLACK, board.cell(Coordinate.at("F1"))));

        // add queens
        board.cell(Coordinate.at("D1")).occupy(new Queen(Cell.Colour.WHITE, board.cell(Coordinate.at("D1"))));
        board.cell(Coordinate.at("D8")).occupy(new Queen(Cell.Colour.BLACK, board.cell(Coordinate.at("D8"))));

        // add kings
        board.cell(Coordinate.at("E1")).occupy(new King(Cell.Colour.WHITE, board.cell(Coordinate.at("E1"))));
        board.cell(Coordinate.at("E8")).occupy(new King(Cell.Colour.BLACK, board.cell(Coordinate.at("E8"))));

        return board;
    }
}
