package ru.bukharovsi;

import ru.bukharovsi.exceptions.CoordinateException;

import java.util.*;

/**
 * Coordinate of Cell, as Example E2, E4, D5
 */
public class Coordinate implements Comparable<Coordinate> {

    private Character x;

    private int y;

    public static ArrayList<Character> HORIZONTAL_NAMES = new ArrayList<>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'));

    public static Collection<Integer> VERTICAL_NAMES = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);


    public Coordinate(Character x, int y) {
        x = Character.toUpperCase(x);
        Objects.requireNonNull(y);
        if (! xIsValid(x)) {
            throw new IllegalArgumentException(String.format("X '%d' coordinate not valid", x));
        }
        if (! yIsValid(y)) {
            throw new IllegalArgumentException(String.format("Y '%s' coordinate not valid", y));
        }

        this.x = x;
        this.y = y;
    }

    public static Coordinate at(String coordinateCouple) {
        char[] coordinates = coordinateCouple.toCharArray();
        if (coordinates.length != 2) {
            throw new IllegalArgumentException(
                    String.format("Coordinate %s is not valid. Coordinates miust contains 2 chairs", coordinateCouple)
            );
        }

        Character x = coordinates[0];
        int y = Integer.parseInt(String.valueOf(coordinates[1]));
        return new Coordinate(x, y);

    }

    private boolean yIsValid(int y) {
        return VERTICAL_NAMES.contains(y);
    }

    private boolean xIsValid(Character x) {
        return HORIZONTAL_NAMES.contains(x);
    }

    public Integer y() {
        return y;
    }

    public Character x() {
        return x;
    }

    public boolean possibleToMoveUp() {
        return y != 8;
    }

    public Coordinate moveUp() {
        if (! possibleToMoveUp()) {
            throw CoordinateException.moveUpException();
        }
        return new Coordinate(x, y+1);
    }

    public boolean possibleToMoveDown() {
        return y != 1;
    }

    public Coordinate moveDown() {
        if (!possibleToMoveDown()) {
            throw CoordinateException.moveDownException();
        }
        return new Coordinate(x, y-1);
    }

    public boolean posibleToMoveRight() {
        return this.x != 'H';
    }

    public Coordinate moveRight() {
        if (!posibleToMoveRight()) {
            throw CoordinateException.moveRightException();
        }

        int newCharIndex = HORIZONTAL_NAMES.indexOf(this.x) + 1;
        return new Coordinate(HORIZONTAL_NAMES.get(newCharIndex), this.y);
    }

    public boolean possibleToMoveLeft() {
        return this.x != 'A';
    }

    public Coordinate moveLeft() {
        if (!possibleToMoveLeft()) {
            throw CoordinateException.moveLeftException();
        }

        int newCharIndex = HORIZONTAL_NAMES.indexOf(this.x) - 1;
        return new Coordinate(HORIZONTAL_NAMES.get(newCharIndex), this.y);
    }

    @Override
    public int compareTo(Coordinate anotherCoordinate) {
        return this.toString().compareTo(anotherCoordinate.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return y == that.y &&
                Objects.equals(x, that.x);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return x().toString() + y().toString();
    }
}
