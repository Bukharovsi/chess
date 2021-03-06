package ru.bukharovsi.chess.domains.rules.moveRules;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import ru.bukharovsi.chess.domains.field.Coordinate;

import java.util.Collection;

public class MoveHorizontalToBoarderRuleTest {

    @Test
    public void whenStayAtTheCornerCanGoOnlyOneDirection() {
        MoveRule horizontal = new MoveHorizontalToBoarderRule();
        Collection<Coordinate> movements = horizontal.possibleMovementsFrom(Coordinate.at("A1"));

        Assert.assertEquals(7, movements.size());
        Assert.assertThat(movements, Matchers.hasItem(Coordinate.at("B1")));
        Assert.assertThat(movements, Matchers.hasItem(Coordinate.at("C1")));
        Assert.assertThat(movements, Matchers.hasItem(Coordinate.at("D1")));
        Assert.assertThat(movements, Matchers.hasItem(Coordinate.at("E1")));
        Assert.assertThat(movements, Matchers.hasItem(Coordinate.at("F1")));
        Assert.assertThat(movements, Matchers.hasItem(Coordinate.at("G1")));
        Assert.assertThat(movements, Matchers.hasItem(Coordinate.at("H1")));
    }

    @Test
    public void whenStayAtTheCenteCanGoBothDirections() {
        MoveRule horizontal = new MoveHorizontalToBoarderRule();
        Collection<Coordinate> movements = horizontal.possibleMovementsFrom(Coordinate.at("F1"));

        Assert.assertEquals(7, movements.size());
        Assert.assertThat(movements, Matchers.hasItem(Coordinate.at("A1")));
        Assert.assertThat(movements, Matchers.hasItem(Coordinate.at("B1")));
        Assert.assertThat(movements, Matchers.hasItem(Coordinate.at("C1")));
        Assert.assertThat(movements, Matchers.hasItem(Coordinate.at("D1")));
        Assert.assertThat(movements, Matchers.hasItem(Coordinate.at("E1")));
        Assert.assertThat(movements, Matchers.hasItem(Coordinate.at("G1")));
        Assert.assertThat(movements, Matchers.hasItem(Coordinate.at("H1")));
    }
}