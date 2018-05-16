package ru.bukharovsi.rules.moveRules;

import org.junit.Rule;
import ru.bukharovsi.Coordinate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class AggregateRule extends AbstractMoveRule {

    private Collection<MoveRules> moveRules;

    public AggregateRule(Collection<MoveRules> moveRules) {
        this.moveRules = moveRules;
    }

    public AggregateRule() {
        this(new HashSet<>());
    }

    @Override
    public Collection<Coordinate> possibleMovementsFrom(Coordinate from) {
        Collection<Coordinate> possibleRules = new HashSet<>();
        for (MoveRules rule : moveRules) {
            possibleRules.addAll(rule.possibleMovementsFrom(from));
        }

        return possibleRules;
    }

    public AggregateRule addRule(MoveRules rule) {
        moveRules.add(rule);
        return this;
    }
}
