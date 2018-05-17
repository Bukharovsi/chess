package ru.bukharovsi.chess.domains;

import ru.bukharovsi.chess.domains.chessmans.*;
import ru.bukharovsi.chess.domains.field.Cell;
import ru.bukharovsi.chess.domains.field.ChessBoard;
import ru.bukharovsi.chess.domains.field.Coordinate;

/**
 * Fill chessboard
 */
public class ChessmanDistributor {

    private ChessBoard board;

    public ChessmanDistributor(ChessBoard gameBoard) {
        this.board = gameBoard;
    }

    public ChessBoard distributeChessmen() {
        // put white pawns
        for (Character currenChar : Coordinate.HORIZONTAL_NAMES) {
            Cell currentCell = board.cell(new Coordinate(currenChar, 2));
            currentCell.occupy(new Pawn(Colour.WHITE, currentCell));
        }

        // put black pawns
        for (Character currenChar : Coordinate.HORIZONTAL_NAMES) {
            Cell currentCell = board.cell(new Coordinate(currenChar, 7));
            currentCell.occupy(new Pawn(Colour.BLACK, currentCell));
        }

        // add rooks
        board.cell(Coordinate.at("A1")).occupy(new Rook(Colour.WHITE, board.cell(Coordinate.at("A1"))));
        board.cell(Coordinate.at("H1")).occupy(new Rook(Colour.WHITE, board.cell(Coordinate.at("H1"))));
        board.cell(Coordinate.at("A8")).occupy(new Rook(Colour.BLACK, board.cell(Coordinate.at("A1"))));
        board.cell(Coordinate.at("H8")).occupy(new Rook(Colour.BLACK, board.cell(Coordinate.at("H8"))));

        // add bishops
        board.cell(Coordinate.at("C1")).occupy(new Bishop(Colour.WHITE, board.cell(Coordinate.at("C1"))));
        board.cell(Coordinate.at("F1")).occupy(new Bishop(Colour.WHITE, board.cell(Coordinate.at("F1"))));
        board.cell(Coordinate.at("C8")).occupy(new Bishop(Colour.BLACK, board.cell(Coordinate.at("C1"))));
        board.cell(Coordinate.at("F8")).occupy(new Bishop(Colour.BLACK, board.cell(Coordinate.at("F1"))));

        // add queens
        board.cell(Coordinate.at("D1")).occupy(new Queen(Colour.WHITE, board.cell(Coordinate.at("D1"))));
        board.cell(Coordinate.at("D8")).occupy(new Queen(Colour.BLACK, board.cell(Coordinate.at("D8"))));

        // add kings
        board.cell(Coordinate.at("E1")).occupy(new King(Colour.WHITE, board.cell(Coordinate.at("E1"))));
        board.cell(Coordinate.at("E8")).occupy(new King(Colour.BLACK, board.cell(Coordinate.at("E8"))));

        return board;
    }
}
