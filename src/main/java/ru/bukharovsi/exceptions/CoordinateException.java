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
        return new CoordinateException("Cannot move to right because you already at the boarder");
    }

    public static CoordinateException moveLeftException() {
        return new CoordinateException("Cannot move to left because you already at the boarder");
    }

    public static CoordinateException moveRightUpException() {
        return new CoordinateException("Cannot move to right up because you already at the boarder");
    }

    public static CoordinateException moveRightDownException() {
        return new CoordinateException("Cannot move to right down because you already at the boarder");
    }

    public static CoordinateException moveLeftDownException() {
        return new CoordinateException("Cannot move to left down because you already at the boarder");
    }

    public static CoordinateException moveLeftUpException() {
        return new CoordinateException("Cannot move to left up because you already at the boarder");
    }
}
