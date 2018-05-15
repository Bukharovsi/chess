package ru.bukharovsi;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

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

}