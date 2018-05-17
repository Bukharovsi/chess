package ru.bukharovsi.chess.game.playerDialogs;

import ru.bukharovsi.chess.domains.chessmans.Chessman;
import ru.bukharovsi.chess.domains.field.Cell;
import ru.bukharovsi.chess.domains.field.ChessBoard;
import ru.bukharovsi.chess.game.Player;

import java.util.Scanner;

public class ConsoleDialog {

    private Scanner scanner;

    public ConsoleDialog(Scanner scanner) {
        this.scanner = scanner;
    }

    public void printGreeting(int turnCounter) {
        System.out.println(String.format("**********NEW (%d) TURN***********", turnCounter));
        System.out.println("Current board state is");
    }

    public void printChessboard(ChessBoard chessBoard) {
        System.out.println(chessBoard);
    }

    public String selectCellForMovement(Player currentPlayer) {
        System.out.println(currentPlayer + " please, choose chessman (type E2, as example)");
        return scanner.nextLine();
    }

    public void printErrorCellNotOccupaied() {
        System.out.println("Cell is empty, please choose another cell. Press enter co continue");
        scanner.nextLine();
    }

    public void printErrorCellIsNotYour() {
        System.out.println("You selected not your chessman. Try another. Press enter co continue");
        scanner.nextLine();
    }

    public void printPossibleDirections(Cell currentCell) {
        System.out.println(String.format("You can move %s to following destinations:", currentCell.getOccupant()));
        currentCell.getOccupant().possibleMovements().forEach(System.out::println);
    }

    public String  printSelectDestinationCell(Player currentPlayer) {
        System.out.println(currentPlayer + " please, choose destination (type E4, as example)");
        String destinationPosition = scanner.nextLine();
        return destinationPosition;
    }

    public void printErrorNotPossibleToGoTo(Chessman currentChessman, Cell destCell) {
        System.out.println(String.format(
                "You can`t move %s to %s. Press enter co continue", currentChessman, destCell.coordinate()));
        scanner.nextLine();
    }

    public void printMotionIsSuccess(Chessman currentChessman, Cell currentCell, Cell destCell) {
        System.out.println(String.format(
                "You moved %s from %s to %s", currentChessman, currentCell.coordinate(), destCell.coordinate()));
        System.out.println("Press enter to continue");
        scanner.nextLine();
        System.out.println("**********TURN FINISHED***********");
    }

    public void printErrorMessage(String message) {
        System.out.println(String.format("something wrong: %s", message));
        System.out.println("Press enter to continue");
        scanner.nextLine();
    }

    public void printWinner(Player winner) {
        System.out.println(String.format("%s player is WIN. game over", winner));
        scanner.nextLine();
    }
}
