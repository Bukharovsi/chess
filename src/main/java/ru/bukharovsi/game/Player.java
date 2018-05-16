package ru.bukharovsi.game;

import lombok.Getter;
import lombok.experimental.Accessors;
import ru.bukharovsi.Cell;

@Getter
@Accessors(fluent = true)
public class Player {

    private String name;

    private Cell.Colour colour;

    public Player(String name, Cell.Colour colour) {
        this.name = name;
        this.colour = colour;
    }

    @Override
    public String toString() {
        return name + "(" + colour + ")";
    }
}
