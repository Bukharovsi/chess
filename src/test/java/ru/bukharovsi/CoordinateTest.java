package ru.bukharovsi;

import org.junit.Assert;
import org.junit.Test;

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
}