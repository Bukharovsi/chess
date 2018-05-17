package ru.bukharovsi.chess.game;

import lombok.Getter;
import lombok.experimental.Accessors;
import ru.bukharovsi.chess.domains.Colour;


/**
 * Represents a game player. Player has a nickname and a colour.
 * The player's colour defines colour of chessmen
 */
@Getter
@Accessors(fluent = true)
public class Player {

    private String name;

    private Colour colour;

    public Player(String name, Colour colour) {
        this.name = name;
        this.colour = colour;
    }

    @Override
    public String toString() {
        return name + "(" + colour + ")";
    }
}
