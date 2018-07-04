package main.agentspeak;

import main.agentspeak.logical_expressions.BeliefAtom;
import main.agentspeak.logical_expressions.terminals.BeliefLiteral;

import java.util.HashSet;

public abstract class LogicalExpression {

    public abstract boolean isGround();

    public abstract boolean isConjunctive();

    public abstract boolean isDisjunctive();

    public abstract HashSet<BeliefAtom> getBeliefAtoms();

    public abstract HashSet<BeliefLiteral> getBeliefLiterals() throws Exception;

    public abstract LogicalExpression substitute(Unifier unifier);

}
