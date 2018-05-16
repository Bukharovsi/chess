package ru.bukharovsi.game;

import ru.bukharovsi.Cell;
import ru.bukharovsi.ChessBoard;
import ru.bukharovsi.chessmans.Chessman;

import java.util.Scanner;

/**
 * Represents a game lap
 */
public class Game {

    private ChessBoard chessBoard;

    private Player whitePlayer;

    private Player blackPlayer;

    private Player currentPlayer;

    private Scanner scanner;

    private Integer turnCounter;

    public Game() {
        chessBoard = new ChessBoard();
        whitePlayer = new Player("Jack", Cell.Colour.WHITE);
        blackPlayer = new Player("Tom", Cell.Colour.BLACK);
        scanner = new Scanner(System.in);

        currentPlayer = whitePlayer;
        turnCounter = 1;
    }

    public void start() {
        while (true) {

            try {
                System.out.println(String.format("**********NEW (%d) TURN***********", turnCounter));
                System.out.println("Current board state is");
                System.out.println(chessBoard);

                System.out.println(currentPlayer + " please, choose chessman (type E2, as example)");
                String positionForMove = scanner.nextLine();
                Cell currentCell = chessBoard.cell(positionForMove);

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

                System.out.println(String.format("You can move %s to following destinations:", currentChessman));
                currentCell.getOccupant().possibleMovements().forEach(System.out::println);

                System.out.println(currentPlayer + " please, choose destination (type E4, as example)");
                String destinationPosition = scanner.nextLine();
                Cell destCell = chessBoard.cell(destinationPosition);

                if (! currentChessman.isPossibleToGoTo(destCell)) {
                    System.out.println(String.format("You can`t move %s to %s. Press enter co continue", currentChessman, destCell));
                    scanner.nextLine();
                    continue;
                }

                currentChessman.goTo(destCell);
                System.out.println(String.format("You moved %s from %s to %s", currentChessman, currentCell, destinationPosition));
                System.out.println("press enter");
                scanner.nextLine();

                if (currentPlayer == whitePlayer) {
                    currentPlayer = blackPlayer;
                } else {
                    currentPlayer = whitePlayer;
                }

                System.out.println(String.format("**********TURN (%d) FINISHED***********", turnCounter));
                turnCounter++;
            } catch (Exception ex) {
                System.out.println(String.format("something wrong: %s", ex.getMessage()));
                System.out.println("press enter");
                scanner.nextLine();
            }


        }
    }
}
