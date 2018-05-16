package ru.bukharovsi.rules.moveRules;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import ru.bukharovsi.Coordinate;

import java.util.Collection;

import static org.junit.Assert.*;

public class MoveVerticalToBoarderTest {

    @Test
    public void whenStayAtTheCornerCanGoOnlyOneDirection() {
        MoveRules horizontal = new MoveVerticalToBoarder();
        Collection<Coordinate> movements = horizontal.possibleMovementsFrom(Coordinate.at("A1"));

        Assert.assertEquals(7, movements.size());
        Assert.assertThat(movements, Matchers.hasItem(Coordinate.at("A2")));
        Assert.assertThat(movements, Matchers.hasItem(Coordinate.at("A3")));
        Assert.assertThat(movements, Matchers.hasItem(Coordinate.at("A4")));
        Assert.assertThat(movements, Matchers.hasItem(Coordinate.at("A5")));
        Assert.assertThat(movements, Matchers.hasItem(Coordinate.at("A6")));
        Assert.assertThat(movements, Matchers.hasItem(Coordinate.at("A7")));
        Assert.assertThat(movements, Matchers.hasItem(Coordinate.at("A8")));
    }

    @Test
    public void whenStayAtTheCenterCanGoBothDirections() {
        MoveRules horizontal = new MoveVerticalToBoarder();
        Collection<Coordinate> movements = horizontal.possibleMovementsFrom(Coordinate.at("A5"));

        Assert.assertEquals(7, movements.size());
        Assert.assertThat(movements, Matchers.hasItem(Coordinate.at("A1")));
        Assert.assertThat(movements, Matchers.hasItem(Coordinate.at("A2")));
        Assert.assertThat(movements, Matchers.hasItem(Coordinate.at("A3")));
        Assert.assertThat(movements, Matchers.hasItem(Coordinate.at("A4")));
        Assert.assertThat(movements, Matchers.hasItem(Coordinate.at("A6")));
        Assert.assertThat(movements, Matchers.hasItem(Coordinate.at("A7")));
        Assert.assertThat(movements, Matchers.hasItem(Coordinate.at("A8")));
    }

}