package ru.bukharovsi.chessmans;


import ru.bukharovsi.Cell;

import java.util.Collection;

public interface Chessman {

    Cell.Colour colour();

    void goTo(Cell cell);

    void hackTo(Cell cell);

    boolean isPossibleToGoTo(Cell cell);

    boolean isPossibleToHackTo(Cell cell);

    Collection<Cell> possibleMovements();

}
