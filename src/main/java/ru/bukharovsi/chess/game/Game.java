package ru.bukharovsi.chess.game;

import ru.bukharovsi.chess.domains.ChessmanDistributor;
import ru.bukharovsi.chess.domains.Colour;
import ru.bukharovsi.chess.domains.chessmans.Chessman;
import ru.bukharovsi.chess.domains.field.Cell;
import ru.bukharovsi.chess.domains.field.ChessBoard;

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

    private Scanner scanner;

    private Integer turnCounter;

    private Chessman kingOfWhitePlayer;

    private Chessman kingOfBlackPlayer;

    public Game() {
        chessBoard = new ChessBoard();
        new ChessmanDistributor(chessBoard).distributeChessmen();

        whitePlayer = new Player("Jack", Colour.WHITE);
        blackPlayer = new Player("Tom", Colour.BLACK);

        scanner = new Scanner(System.in);

        currentPlayer = whitePlayer;
        turnCounter = 1;

        kingOfWhitePlayer = chessBoard.cell("E1").getOccupant();
        kingOfBlackPlayer = chessBoard.cell("E8").getOccupant();
    }

    public void start() {
        while (true) {

            try {
                // Select a cell
                System.out.println(String.format("**********NEW (%d) TURN***********", turnCounter));
                System.out.println("Current board state is");
                System.out.println(chessBoard);

                System.out.println(currentPlayer + " please, choose chessman (type E2, as example)");
                String positionForMove = scanner.nextLine();
                Cell currentCell = chessBoard.cell(positionForMove);

                // Check if chessman is correct
                if (! currentCell.isOccupaied()) {
                    System.out.println("Cell is empty, please choose another cell. Press enter co continue");
                    scanner.nextLine();
                    continue;
                }

                Chessman currentChessman = currentCell.getOccupant();

                if (! currentChessman.colour().equals(currentPlayer.colour())) {
                    System.out.println("You selected not your chessman. Try another. Press enter co continue");
                    scanner.nextLine();
                    continue;
                }

                // Select destination
                System.out.println(String.format("You can move %s to following destinations:", currentChessman));
                currentCell.getOccupant().possibleMovements().forEach(System.out::println);

                System.out.println(currentPlayer + " please, choose destination (type E4, as example)");
                String destinationPosition = scanner.nextLine();
                Cell destCell = chessBoard.cell(destinationPosition);

                if (! currentChessman.isPossibleToGoTo(destCell)) {
                    System.out.println(String.format(
                            "You can`t move %s to %s. Press enter co continue", currentChessman, destCell.coordinate()));
                    scanner.nextLine();
                    continue;
                }

                // make action
                currentChessman.goTo(destCell);
                System.out.println(String.format(
                        "You moved %s from %s to %s", currentChessman, currentCell.coordinate(), destinationPosition));
                System.out.println("Press enter to continue");
                scanner.nextLine();

                if (currentPlayer == whitePlayer) {
                    currentPlayer = blackPlayer;
                } else {
                    currentPlayer = whitePlayer;
                }

                System.out.println(String.format("**********TURN (%d) FINISHED***********", turnCounter));
                turnCounter++;

                //checkWinner
                if (! kingOfBlackPlayer.isAlive()) {
                    System.out.println("White player is WIN. game over");
                    scanner.nextLine();
                    return;
                }

                if (! kingOfWhitePlayer.isAlive()) {
                    System.out.println("Black player is WIN. game over");
                    scanner.nextLine();
                    return;
                }

            } catch (Exception ex) {
                System.out.println(String.format("something wrong: %s", ex.getMessage()));
                System.out.println("Press enter to continue");
                scanner.nextLine();
            }


        }
    }
}
