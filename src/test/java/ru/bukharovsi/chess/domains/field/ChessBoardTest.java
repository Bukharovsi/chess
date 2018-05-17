package ru.bukharovsi.chess.domains.field;

import org.junit.Assert;
import org.junit.Test;

public class ChessBoardTest {

    @Test
    public void whenBoardAreCreatedThenItMustBeFilledProperly() {
        ChessBoard chessBoard = new ChessBoard();

        Assert.assertTrue(chessBoard.cell(Coordinate.at("A1")).colour().isBlack());
        Assert.assertTrue(chessBoard.cell(Coordinate.at("A2")).colour().isWhite());
        Assert.assertTrue(chessBoard.cell(Coordinate.at("A3")).colour().isBlack());
        Assert.assertTrue(chessBoard.cell(Coordinate.at("B1")).colour().isWhite());
        Assert.assertTrue(chessBoard.cell(Coordinate.at("H2")).colour().isBlack());
        Assert.assertTrue(chessBoard.cell(Coordinate.at("H8")).colour().isBlack());
    }

    @Test
    public void name() {
//        ChessBoard chessBoard = new ChessBoard();
//        System.out.println(chessBoard.cell("A2").getOccupant().possibleMovements());
//        chessBoard.cell("A2").getOccupant().goTo(chessBoard.cell("A5"));
//        System.out.println(chessBoard.toString());
    }
}