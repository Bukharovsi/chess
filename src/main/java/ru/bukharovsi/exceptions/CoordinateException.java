package ru.bukharovsi.exceptions;

public class CoordinateException extends RuntimeException {

    public CoordinateException(String message) {
        super(message);
    }

    public static CoordinateException moveUpException() {
        return new CoordinateException("Cannot move Up because you already at the boarder");
    }

    public static CoordinateException moveDownException() {
        return new CoordinateException("Cannot move Down because you already at the boarder");
    }

    public static CoordinateException moveRightException() {
        return new CoordinateException("Cannot move right because you already at the boarder");
    }

    public static CoordinateException moveLeftException() {
        return new CoordinateException("Cannot move left because you already at the boarder");
    }
}
