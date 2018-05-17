package ru.bukharovsi.chess.domains.rules.moveRules;

import ru.bukharovsi.chess.domains.field.Coordinate;

import java.util.Collection;
import java.util.HashSet;

public class AggregateRule extends AbstractMoveRule {

    private Collection<MoveRule> moveRules;

    public AggregateRule(Collection<MoveRule> moveRules) {
        this.moveRules = moveRules;
    }

    public AggregateRule() {
        this(new HashSet<>());
    }

    @Override
    public Collection<Coordinate> possibleMovementsFrom(Coordinate from) {
        Collection<Coordinate> possibleRules = new HashSet<>();
        for (MoveRule rule : moveRules) {
            possibleRules.addAll(rule.possibleMovementsFrom(from));
        }

        return possibleRules;
    }

    public AggregateRule addRule(MoveRule rule) {
        moveRules.add(rule);
        return this;
    }
}
