package ru.bukharovsi.rules.moveRules;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import ru.bukharovsi.Coordinate;

import java.util.ArrayList;
import java.util.Collection;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasItems;

public class AggregateRuleTest {

    @Test
    public void whenAggregateRuleHasOnlyOneRuleTheResultsAreEquals() {
        AggregateRule aggregateRule = new AggregateRule();
        MoveRules innerRule = new MoveHorizontalToBoarder();
        aggregateRule.addRule(innerRule);

        Coordinate e2 = Coordinate.at("E2");
        Assert.assertEquals(innerRule.possibleMovementsFrom(e2).size(), aggregateRule.possibleMovementsFrom(e2).size());
        Assert.assertThat(
                aggregateRule.possibleMovementsFrom(e2),
                containsInAnyOrder(innerRule.possibleMovementsFrom(e2).toArray())
        );
    }

    @Test
    public void whenAggregateRuleHas2RuleSTheResultisSumOfTwoRules() {
        AggregateRule aggregateRule = new AggregateRule();
        MoveRules innerRule1 = new MoveHorizontalToBoarder();
        MoveRules innerRule2 = new MoveVerticalToBoarder();
        aggregateRule.addRule(innerRule1);
        aggregateRule.addRule(innerRule2);

        Coordinate e2 = Coordinate.at("E2");
        Assert.assertEquals(
                innerRule1.possibleMovementsFrom(e2).size() + innerRule2.possibleMovementsFrom(e2).size(),
                aggregateRule.possibleMovementsFrom(e2).size()
        );
    }


}