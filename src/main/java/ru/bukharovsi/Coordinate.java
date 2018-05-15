package ru.bukharovsi;

import java.util.Objects;

public class Coordinate {

    private Character x;

    private int y;


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

    private boolean yIsValid(int y) {
        return y <=8 && y> 0;
    }

    private boolean xIsValid(Character x) {
        return "ABCDEFGH".contains(x.toString());
    }

    public Integer y() {
        return y;
    }

    public Character x() {
        return x;
    }

    @Override
    public String toString() {
        return x().toString() + y().toString();
    }
}
