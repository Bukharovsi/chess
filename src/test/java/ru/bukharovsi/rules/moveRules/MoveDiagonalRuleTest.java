package ru.bukharovsi.rules.moveRules;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import ru.bukharovsi.Coordinate;

import java.util.Collection;

public class MoveDiagonalRuleTest {

    @Test
    public void whenStayAtCornerOnlyOneDiagonalPossible() {
        MoveRule rule = new MoveDiagonalRule();
        Collection<Coordinate> possibleMovements = rule.possibleMovementsFrom(Coordinate.at("A1"));

        Assert.assertEquals(7, possibleMovements.size());
        Assert.assertThat(possibleMovements, Matchers.hasItem(Coordinate.at("B2")));
        Assert.assertThat(possibleMovements, Matchers.hasItem(Coordinate.at("C3")));
        Assert.assertThat(possibleMovements, Matchers.hasItem(Coordinate.at("D4")));
        Assert.assertThat(possibleMovements, Matchers.hasItem(Coordinate.at("E5")));
        Assert.assertThat(possibleMovements, Matchers.hasItem(Coordinate.at("F6")));
        Assert.assertThat(possibleMovements, Matchers.hasItem(Coordinate.at("G7")));
        Assert.assertThat(possibleMovements, Matchers.hasItem(Coordinate.at("H8")));
    }

    @Test
    public void whenStayAtCenterAllDiagonalsAreAvailable() {
        MoveRule rule = new MoveDiagonalRule();
        Collection<Coordinate> possibleMovements = rule.possibleMovementsFrom(Coordinate.at("E5"));

        Assert.assertEquals(13, possibleMovements.size());
        Assert.assertThat(possibleMovements, Matchers.hasItem(Coordinate.at("A1")));
        Assert.assertThat(possibleMovements, Matchers.hasItem(Coordinate.at("B2")));
        Assert.assertThat(possibleMovements, Matchers.hasItem(Coordinate.at("C3")));
        Assert.assertThat(possibleMovements, Matchers.hasItem(Coordinate.at("D4")));
        Assert.assertThat(possibleMovements, Matchers.hasItem(Coordinate.at("F6")));
        Assert.assertThat(possibleMovements, Matchers.hasItem(Coordinate.at("G7")));
        Assert.assertThat(possibleMovements, Matchers.hasItem(Coordinate.at("H8")));

        Assert.assertThat(possibleMovements, Matchers.hasItem(Coordinate.at("D6")));
        Assert.assertThat(possibleMovements, Matchers.hasItem(Coordinate.at("C7")));
        Assert.assertThat(possibleMovements, Matchers.hasItem(Coordinate.at("B8")));
        Assert.assertThat(possibleMovements, Matchers.hasItem(Coordinate.at("F4")));
        Assert.assertThat(possibleMovements, Matchers.hasItem(Coordinate.at("G3")));
        Assert.assertThat(possibleMovements, Matchers.hasItem(Coordinate.at("H2")));
    }

}