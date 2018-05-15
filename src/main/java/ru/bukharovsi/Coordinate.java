package ru.bukharovsi;

import ru.bukharovsi.exceptions.CoordinateException;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public class Coordinate implements Comparable<Coordinate> {

    private Character x;

    private int y;

    public static String X_COORDINATES = "ABCDEFGH";

    public static Collection<Integer> Y_COORDINATES = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);


    public Coordinate(Character x, int y) {
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
        return Y_COORDINATES.contains(y);
    }

    private boolean xIsValid(Character x) {
        return X_COORDINATES.contains(x.toString());
    }

    public Integer y() {
        return y;
    }

    public Character x() {
        return x;
    }

    public Coordinate moveUp() {
        if (y == 8) {
            throw CoordinateException.moveUpException();
        }
        return new Coordinate(x, y+1);
    }

    public Coordinate moveDown() {
        if (y == 1) {
            throw CoordinateException.moveDownException();
        }
        return new Coordinate(x, y-1);
    }

    public Coordinate moveRight() {
        if (this.x == 'H') {
            throw CoordinateException.moveRightException();
        }

        int newCharIndex = X_COORDINATES.indexOf(this.x) + 1;
        return new Coordinate(X_COORDINATES.charAt(newCharIndex), this.y);
    }

    public Coordinate moveLeft() {
        if (this.x == 'A') {
            throw CoordinateException.moveLeftException();
        }

        int newCharIndex = X_COORDINATES.indexOf(this.x) - 1;
        return new Coordinate(X_COORDINATES.charAt(newCharIndex), this.y);
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
