package ru.bukharovsi.chess.domains.rules;

import org.junit.Assert;
import org.junit.Test;
import ru.bukharovsi.chess.domains.rules.moveRules.MoveUpOneStepRule;
import ru.bukharovsi.chess.domains.field.Coordinate;

import java.util.Collection;

public class MoveUpOneStepRuleTest {

    @Test
    public void pawnMustGoStraight() {
        MoveUpOneStepRule rule = new MoveUpOneStepRule();
        Collection<Coordinate> possibleMovements = rule.possibleMovementsFrom(Coordinate.at("E2"));
        Assert.assertEquals(1, possibleMovements.size());
        Assert.assertEquals(Coordinate.at("E3"), possibleMovements.iterator().next());
    }

    @Test
    public void pawnMustGoStraightWithPossibleMovements() {
        MoveUpOneStepRule rule = new MoveUpOneStepRule();
        Assert.assertTrue(rule.possibleToMove(Coordinate.at("E2"), Coordinate.at("E3")));
        Assert.assertFalse(rule.possibleToMove(Coordinate.at("E2"), Coordinate.at("E1")));
    }
}