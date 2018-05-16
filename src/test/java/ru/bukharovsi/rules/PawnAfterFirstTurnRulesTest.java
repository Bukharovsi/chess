package ru.bukharovsi.rules;

import org.junit.Assert;
import org.junit.Test;
import ru.bukharovsi.Coordinate;
import ru.bukharovsi.rules.moveRules.PawnAfterFirstTurnRules;

import java.util.Collection;

public class PawnAfterFirstTurnRulesTest {

    @Test
    public void pawnMustGoStraight() {
        PawnAfterFirstTurnRules rule = new PawnAfterFirstTurnRules();
        Collection<Coordinate> possibleMovements = rule.possibleMovementsFrom(Coordinate.at("E2"));
        Assert.assertEquals(1, possibleMovements.size());
        Assert.assertEquals(Coordinate.at("E3"), possibleMovements.iterator().next());
    }

    @Test
    public void pawnMustGoStraightWithPossibleMovements() {
        PawnAfterFirstTurnRules rule = new PawnAfterFirstTurnRules();
        Assert.assertTrue(rule.possibleToMove(Coordinate.at("E2"), Coordinate.at("E3")));
        Assert.assertFalse(rule.possibleToMove(Coordinate.at("E2"), Coordinate.at("E1")));
    }
}