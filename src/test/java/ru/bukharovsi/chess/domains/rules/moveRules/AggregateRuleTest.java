package ru.bukharovsi.chess.domains.rules.moveRules;

import org.junit.Assert;
import org.junit.Test;
import ru.bukharovsi.chess.domains.field.Coordinate;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasItems;

public class AggregateRuleTest {

    @Test
    public void whenAggregateRuleHasOnlyOneRuleTheResultsAreEquals() {
        AggregateRule aggregateRule = new AggregateRule();
        MoveRule innerRule = new MoveHorizontalToBoarderRule();
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
        MoveRule innerRule1 = new MoveHorizontalToBoarderRule();
        MoveRule innerRule2 = new MoveVerticalToBoarderRule();
        aggregateRule.addRule(innerRule1);
        aggregateRule.addRule(innerRule2);

        Coordinate e2 = Coordinate.at("E2");
        Assert.assertEquals(
                innerRule1.possibleMovementsFrom(e2).size() + innerRule2.possibleMovementsFrom(e2).size(),
                aggregateRule.possibleMovementsFrom(e2).size()
        );
    }


}