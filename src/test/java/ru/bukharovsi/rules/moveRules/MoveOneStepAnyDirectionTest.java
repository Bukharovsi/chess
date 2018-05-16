package ru.bukharovsi.rules.moveRules;

import org.junit.Assert;
import org.junit.Test;
import ru.bukharovsi.Coordinate;

import static org.junit.Assert.*;

public class MoveOneStepAnyDirectionTest {

    @Test
    public void whenStayAtCenterCanMoveTo8Cells() {
        MoveRules rule = new MoveOneStepAnyDirection();
        Assert.assertEquals(8, rule.possibleMovementsFrom(Coordinate.at("E5")).size());
    }
}