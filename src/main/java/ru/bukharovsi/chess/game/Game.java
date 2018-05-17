package ru.bukharovsi.chess.game;

import ru.bukharovsi.chess.domains.ChessmanDistributor;
import ru.bukharovsi.chess.domains.Colour;
import ru.bukharovsi.chess.domains.chessmans.Chessman;
import ru.bukharovsi.chess.domains.field.Cell;
import ru.bukharovsi.chess.domains.field.ChessBoard;
import ru.bukharovsi.chess.game.playerDialogs.ConsoleDialog;

import java.util.Scanner;

/**
 * Represents a game lap
 * Creates a game world, allows players to make turns
 */
public class Game {

    private ChessBoard chessBoard;

    private Player whitePlayer;

    private Player blackPlayer;

    private Player currentPlayer;

    private Integer turnCounter;

    private Chessman kingOfWhitePlayer;

    private Chessman kingOfBlackPlayer;

    private ConsoleDialog dialog;

    public Game() {
        chessBoard = new ChessBoard();
        new ChessmanDistributor(chessBoard).distributeChessmen();

        whitePlayer = new Player("Jack", Colour.WHITE);
        blackPlayer = new Player("Tom", Colour.BLACK);

        currentPlayer = whitePlayer;
        turnCounter = 1;

        kingOfWhitePlayer = chessBoard.cell("E1").getOccupant();
        kingOfBlackPlayer = chessBoard.cell("E8").getOccupant();

        dialog = new ConsoleDialog(new Scanner(System.in));
    }

    public void start() {
        while (true) {
            try {
                dialog.printGreeting(turnCounter);
                dialog.printChessboard(chessBoard);

                Cell currentCell = chessBoard.cell(dialog.selectCellForMovement(currentPlayer));
                if (! currentCell.isOccupaied()) {
                    dialog.printErrorCellNotOccupaied();
                    continue;
                }

                Chessman currentChessman = currentCell.getOccupant();
                if (! currentChessman.colour().equals(currentPlayer.colour())) {
                    dialog.printErrorCellIsNotYour();
                    continue;
                }

                dialog.printPossibleDirections(currentCell);
                Cell destCell = chessBoard.cell(dialog.printSelectDestinationCell(currentPlayer));
                if (! currentChessman.isPossibleToGoTo(destCell)) {
                    dialog.printErrorNotPossibleToGoTo(currentChessman, destCell);
                    continue;
                }

                currentChessman.goTo(destCell);
                dialog.printMotionIsSuccess(currentChessman, currentCell, destCell);
                switchCurrentPlayer();
                turnCounter++;
                if (isEndOfGame()) return;
            } catch (Exception ex) {
                dialog.printErrorMessage(ex.getMessage());
            }
        }
    }

    private boolean isEndOfGame() {
        if (! kingOfBlackPlayer.isAlive()) {
            dialog.printWinner(whitePlayer);
            return true;
        }

        if (! kingOfWhitePlayer.isAlive()) {
            dialog.printWinner(blackPlayer);
            return true;
        }
        return false;
    }

    private void switchCurrentPlayer() {
        if (currentPlayer == whitePlayer) {
            currentPlayer = blackPlayer;
        } else {
            currentPlayer = whitePlayer;
        }
    }
}
