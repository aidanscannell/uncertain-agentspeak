package main.agentspeak.logical_expressions;

import main.agentspeak.LogicalExpression;
import main.agentspeak.Term;

import java.util.HashSet;

public abstract class Terminal extends LogicalExpression {

    public abstract boolean isGround();

    @Override
    public boolean isDisjunctive() {
        return true;
    }

    @Override
    public boolean isConjunctive() {
        return true;
    }

    @Override
    public boolean isClassical() {
        return true;
    }

    @Override
    public boolean inNNF() {
        return true;
    }

    @Override
    public HashSet<HashSet<Terminal>> getSetClauses() throws UnsupportedOperationException {
        HashSet<Terminal> clause = new HashSet<>();
        clause.add(this);
        HashSet<HashSet<Terminal>> clauses = new HashSet<HashSet<Terminal>>();
        clauses.add(clause);
        return clauses;
    }

    @Override
    public HashSet<Terminal> getTerminals() throws UnsupportedOperationException {
        HashSet<Terminal> terminals = new HashSet<>();
        terminals.add(this);
        return terminals;
    }

    @Override
    public Terminal convertToCNF() throws UnsupportedOperationException {
        return this;
    }
}
