package main.java.uncertain_agentspeak.agentspeak.logical_expressions.operators;

import main.java.uncertain_agentspeak.agentspeak.LogicalExpression;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.BeliefAtom;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.Operator;

import java.util.HashSet;

public abstract class Negation extends Operator {

    private LogicalExpression term;

    public Negation(LogicalExpression logicalExpression) {
        term = logicalExpression;
    }

    public LogicalExpression getTerm() {
        return term;
    }

    @Override
    public boolean isConjunctive() {
        return term.isConjunctive();
    }

    @Override
    public boolean isDisjunctive() {
        return term.isDisjunctive();
    }

    @Override
    public boolean isGround() {
        return term.isGround();
    }

    @Override
    public HashSet<BeliefAtom> getBeliefAtoms() {
        return term.getBeliefAtoms();
    }

}
