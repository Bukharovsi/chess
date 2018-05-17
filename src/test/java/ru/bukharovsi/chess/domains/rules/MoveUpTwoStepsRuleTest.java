package ru.bukharovsi.chess.domains.rules;

import org.junit.Assert;
import org.junit.Test;
import ru.bukharovsi.chess.domains.rules.moveRules.MoveRule;
import ru.bukharovsi.chess.domains.rules.moveRules.MoveUpTwoStepsRule;
import ru.bukharovsi.chess.domains.field.Coordinate;

import java.util.Collection;

import static org.hamcrest.Matchers.*;

public class MoveUpTwoStepsRuleTest {
    @Test
    public void pawnMustGoStraight() {
        MoveRule rule = new MoveUpTwoStepsRule();
        Collection<Coordinate> possibleMovements = rule.possibleMovementsFrom(Coordinate.at("E2"));
        Assert.assertEquals(2, possibleMovements.size());
        Assert.assertThat(possibleMovements, hasItem(Coordinate.at("E3")));
        Assert.assertThat(possibleMovements, hasItem(Coordinate.at("E4")));
    }

    @Test
    public void pawnMustGoStraightWithPossibleMovements() {
        MoveRule rule = new MoveUpTwoStepsRule();
        Assert.assertTrue(rule.possibleToMove(Coordinate.at("E2"), Coordinate.at("E3")));
        Assert.assertTrue(rule.possibleToMove(Coordinate.at("E2"), Coordinate.at("E4")));
        Assert.assertFalse(rule.possibleToMove(Coordinate.at("E2"), Coordinate.at("E1")));
    }
}