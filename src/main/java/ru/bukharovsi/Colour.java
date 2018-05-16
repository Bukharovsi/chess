package ru.bukharovsi;

public enum Colour {
    BLACK,
    WHITE;

    public Colour invert() {
        if (this == BLACK) return WHITE;else return BLACK;
    }

    public boolean isBlack() {
        return this == BLACK;
    }

    public boolean isWhite() {
        return this == WHITE;
    }
}
