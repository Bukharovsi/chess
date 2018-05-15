package ru.bukharovsi;


import org.junit.Assert;
import org.junit.Test;
import ru.bukharovsi.chessmans.Chessman;
import ru.bukharovsi.chessmans.Pawn;
import ru.bukharovsi.exceptions.CantGetAOccupantBecauseCellIsEmpty;
import ru.bukharovsi.exceptions.CantRemoveOccupantBecauseCellIsEmpty;

public class CellTest {

    @Test
    public void newCellIsNotOccupied() {
        Cell e2Cell = new Cell(new Coordinate('E',2), Cell.Colour.WHITE);
        Assert.assertFalse(e2Cell.isOccupaied());
    }

    @Test
    public void whenCellisEmptyThenToStringPrintsProperly() {
        Assert.assertEquals(
                "E2 WHITE is empty",
                new Cell(new Coordinate('E',2), Cell.Colour.WHITE).toString()
        );
    }

    @Test
    public void whenCellIsOccupaiedthenItIsOccupied() {
        Cell e2Cell = new Cell(new Coordinate('E',2), Cell.Colour.WHITE);
        e2Cell.occupy(new Pawn(Cell.Colour.WHITE, e2Cell));
        Assert.assertTrue(e2Cell.isOccupaied());
    }

    @Test
    public void whenCellIsOccupaiedThenOccupantCanBeRemoved() {
        Cell e2Cell = new Cell(new Coordinate('E',2), Cell.Colour.WHITE);
        Chessman pawn = new Pawn(Cell.Colour.WHITE, e2Cell);
        e2Cell.occupy(pawn);
        Assert.assertEquals(pawn, e2Cell.removeOccupant());
        Assert.assertFalse(e2Cell.isOccupaied());
    }

    @Test(expected = CantRemoveOccupantBecauseCellIsEmpty.class)
    public void whenCellIsEmptyThenOccupantCanNotBeRemoved() {
        Cell e2Cell = new Cell(new Coordinate('E',2), Cell.Colour.WHITE);
        e2Cell.removeOccupant();
    }

    @Test(expected = CantGetAOccupantBecauseCellIsEmpty.class)
    public void whenCellIsEmptyThenOccupantCanNotBeGot() {
        Cell e2Cell = new Cell(new Coordinate('E',2), Cell.Colour.WHITE);
        e2Cell.getOccupant();
    }


}
