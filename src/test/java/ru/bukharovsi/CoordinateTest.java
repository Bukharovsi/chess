package ru.bukharovsi;

import org.junit.Assert;
import org.junit.Test;
import ru.bukharovsi.exceptions.CoordinateException;

public class CoordinateTest {

    @Test
    public void whenCoordinatesAreCorrectThenCoordinatesAreCreated() {
        Coordinate e2 = new Coordinate('E', 2);

        Assert.assertEquals("E", e2.x().toString());
        Assert.assertEquals(new Integer(2), e2.y());
    }

    @Test
    public void whenCoordinatesAreCorrectThenToStringAreCorrect() {
        Coordinate e2 = new Coordinate('E', 2);
        Assert.assertEquals("E2", e2.toString());
    }


    @Test(expected = IllegalArgumentException.class)
    public void whenXCoordinateNowValidThenThrowsException() {
        new Coordinate('E', 42);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenYCoordinateNowValidThenThrowsException() {
        new Coordinate('Z', 2);
    }

    @Test
    public void whenCoupleOfCoordinatesAreValidThenCoordinatesMustBeCreated() {
        Assert.assertEquals(Coordinate.at("E2"), new Coordinate('E', 2));
    }

    @Test
    public void whenPossibleCanMoveUp() {
        Assert.assertEquals(Coordinate.at("E3"), Coordinate.at("E2").moveUp());
    }

    @Test
    public void whenPossibleCanMoveDown() {
        Assert.assertEquals(Coordinate.at("E1"), Coordinate.at("E2").moveDown());
    }

    @Test
    public void whenPossibleCanMoveRight() {
        Assert.assertEquals(Coordinate.at("F2"), Coordinate.at("E2").moveRight());
    }

    @Test
    public void whenPossibleCanMoveLeft() {
        Assert.assertEquals(Coordinate.at("D2"), Coordinate.at("E2").moveLeft());
    }

    @Test(expected = CoordinateException.class)
    public void whenNotPossibleCanNotMoveUp() {
        Coordinate.at("E8").moveUp();
    }

    @Test(expected = CoordinateException.class)
    public void whenNotPossibleCanNotMoveDown() {
        Coordinate.at("E1").moveDown();
    }

    @Test(expected = CoordinateException.class)
    public void whenNotPossibleCanNotMoveRight() {
        Coordinate.at("H2").moveRight();
    }

    @Test(expected = CoordinateException.class)
    public void whenNotPossibleCanNotMoveLeft() {
        Coordinate.at("A1").moveLeft();
    }

    @Test
    public void theSameCoordinatesMustBeEquals() {
        Assert.assertEquals(Coordinate.at("E2"), Coordinate.at("E2"));
    }

    @Test
    public void notTheSameCoordinatesMustNotBeEquals() {
        Assert.assertNotEquals(Coordinate.at("E2"), Coordinate.at("D3"));
    }
}