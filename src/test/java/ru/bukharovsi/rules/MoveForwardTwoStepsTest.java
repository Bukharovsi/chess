package ru.bukharovsi.rules;

import org.junit.Assert;
import org.junit.Test;
import ru.bukharovsi.Coordinate;
import ru.bukharovsi.rules.moveRules.MoveRules;
import ru.bukharovsi.rules.moveRules.MoveForwardTwoSteps;

import java.util.Collection;

import static org.hamcrest.Matchers.*;

public class MoveForwardTwoStepsTest {
    @Test
    public void pawnMustGoStraight() {
        MoveRules rule = new MoveForwardTwoSteps();
        Collection<Coordinate> possibleMovements = rule.possibleMovementsFrom(Coordinate.at("E2"));
        Assert.assertEquals(2, possibleMovements.size());
        Assert.assertThat(possibleMovements, hasItem(Coordinate.at("E3")));
        Assert.assertThat(possibleMovements, hasItem(Coordinate.at("E4")));
    }

    @Test
    public void pawnMustGoStraightWithPossibleMovements() {
        MoveRules rule = new MoveForwardTwoSteps();
        Assert.assertTrue(rule.possibleToMove(Coordinate.at("E2"), Coordinate.at("E3")));
        Assert.assertTrue(rule.possibleToMove(Coordinate.at("E2"), Coordinate.at("E4")));
        Assert.assertFalse(rule.possibleToMove(Coordinate.at("E2"), Coordinate.at("E1")));
    }
}