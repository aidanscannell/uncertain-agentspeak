package main.java.uncertain_agentspeak.agentspeak.logical_expressions.operators;

import main.java.uncertain_agentspeak.agentspeak.LogicalExpression;
import main.java.uncertain_agentspeak.agentspeak.Unifier;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.BeliefAtom;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.Operator;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.Terminal;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.terminals.BeliefLiteral;

import java.util.HashSet;

public class GreaterEqualsPlausibility extends Operator {

    private LogicalExpression left;
    private LogicalExpression right;

    public GreaterEqualsPlausibility(LogicalExpression left, LogicalExpression right) throws Exception {
        this.left = left;
        this.right = right;
        if (!this.getLeft().isClassical() || !this.getRight().isClassical()) {
            throw new Exception("Formula must be classical to use this operator");
        }
    }

    public LogicalExpression getLeft() {
        return left;
    }

    public LogicalExpression getRight() {
        return right;
    }

    public GreaterEqualsPlausibility substitute(Unifier unifier) throws Exception {
        return new GreaterEqualsPlausibility(this.getLeft().substitute(unifier), this.getRight().substitute(unifier));
    }

    public boolean isConjunctive() {
        return true;
    }

    public boolean isDisjunctive() {
        return true;
    }

    @Override
    public boolean isClassical() {
        return false;
    }

    public boolean isGround() {
        return this.left.isGround() && this.right.isGround();
    }

    @Override
    public HashSet<BeliefAtom> getBeliefAtoms() {
        HashSet<BeliefAtom> beliefAtoms = (HashSet<BeliefAtom>) left.getBeliefAtoms().clone();
        beliefAtoms.addAll((HashSet<BeliefAtom>) right.getBeliefAtoms().clone());
//        HashSet<BeliefAtom> beliefAtoms = new HashSet<BeliefAtom>();
//        beliefAtoms.addAll((HashSet<BeliefAtom>) left.getBeliefAtoms().clone());
//        beliefAtoms.addAll((HashSet<BeliefAtom>) right.getBeliefAtoms().clone());
        return beliefAtoms;
    }

    @Override
    public HashSet<BeliefLiteral> getBeliefLiterals() throws Exception {
        HashSet<BeliefLiteral> beliefLiterals = (HashSet<BeliefLiteral>) left.getBeliefLiterals().clone();
        beliefLiterals.addAll((HashSet<BeliefLiteral>) right.getBeliefLiterals().clone());
//        HashSet<BeliefLiteral> beliefLiterals = new HashSet<BeliefLiteral>();
//        beliefLiterals.add((BeliefLiteral) left.getBeliefLiterals().clone());
//        beliefLiterals.add((BeliefLiteral) right.getBeliefLiterals().clone());
        return beliefLiterals;
    }

    @Override
    public Operator convertToNNF(boolean propogateStrongNegation) throws Exception {
        if (propogateStrongNegation) {
            return new GreaterThanPlausibility(this.getRight().convertToNNF(propogateStrongNegation),this.getLeft().convertToNNF(propogateStrongNegation));
        } else {
            return new GreaterEqualsPlausibility(this.getLeft().convertToNNF(false), this.getRight().convertToNNF(false));
        }
    }

    @Override
    public boolean inNNF() {
        return this.getLeft().inNNF() && this.getRight().inNNF();
    }

    @Override
    public HashSet<HashSet<Terminal>> getSetClauses() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Formula not in NNF");
    }

    @Override
    public HashSet<Terminal> getTerminals() throws UnsupportedOperationException {
        HashSet<Terminal> terminals = new HashSet<>();
        terminals.addAll(this.getLeft().getTerminals());
        terminals.addAll(this.getRight().getTerminals());
        return terminals;
    }

    @Override
    public GreaterEqualsPlausibility convertToCNF() throws Exception {
        return new GreaterEqualsPlausibility(this.getLeft().convertToCNF(), this.getRight().convertToCNF());
    }

    @Override
    public String toString() {
        return left.toString() + " >= " + right.toString();
    }

}
