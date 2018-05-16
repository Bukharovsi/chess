package ru.bukharovsi.rules.moveRules;

import org.junit.Assert;
import org.junit.Test;
import ru.bukharovsi.Coordinate;

public class MoveOneStepAnyDirectionRuleTest {

    @Test
    public void whenStayAtCenterCanMoveTo8Cells() {
        MoveRule rule = new MoveOneStepAnyDirectionRule();
        Assert.assertEquals(8, rule.possibleMovementsFrom(Coordinate.at("E5")).size());
    }
}