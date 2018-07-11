package main.java.uncertain_agentspeak.agentspeak;

import main.java.uncertain_agentspeak.agentspeak.logical_expressions.BeliefAtom;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.Terminal;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.operators.Conjunction;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.terminals.BeliefLiteral;

import javax.naming.OperationNotSupportedException;
import java.util.HashSet;

public abstract class LogicalExpression {

    public abstract boolean isGround();

    public abstract boolean isConjunctive();

    public abstract boolean isDisjunctive();

    public abstract boolean isClassical();

    public abstract HashSet<BeliefAtom> getBeliefAtoms();

    public abstract HashSet<BeliefLiteral> getBeliefLiterals() throws Exception;

    public abstract LogicalExpression substitute(Unifier unifier) throws Exception;

    public abstract LogicalExpression convertToNNF(boolean propogateStrongNegation) throws Exception;

    public abstract boolean inNNF();

    public abstract HashSet<HashSet<Terminal>> getSetClauses() throws UnsupportedOperationException;

    public abstract HashSet<Terminal> getTerminals() throws UnsupportedOperationException;

    public abstract LogicalExpression convertToCNF() throws Exception;
}
