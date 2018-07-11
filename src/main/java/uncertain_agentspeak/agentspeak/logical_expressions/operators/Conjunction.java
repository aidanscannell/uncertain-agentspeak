package main.java.uncertain_agentspeak.agentspeak.logical_expressions.operators;

import main.java.uncertain_agentspeak.agentspeak.LogicalExpression;
import main.java.uncertain_agentspeak.agentspeak.Unifier;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.BeliefAtom;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.Operator;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.Terminal;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.terminals.BeliefLiteral;

import javax.naming.OperationNotSupportedException;
import java.util.HashSet;

public class Conjunction extends Operator {

    private LogicalExpression left;
    private LogicalExpression right;

    public Conjunction(LogicalExpression left, LogicalExpression right) {
        this.left = left;
        this.right = right;
    }

    public LogicalExpression getLeft() {
        return left;
    }

    public LogicalExpression getRight() {
        return right;
    }

    public Conjunction substitute(Unifier unifier) throws Exception {
        return new Conjunction(this.getLeft().substitute(unifier), this.getRight().substitute(unifier));
    }

    @Override
    public boolean isConjunctive() {
        if (this.getLeft().isConjunctive() && this.getRight().isConjunctive()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isDisjunctive() {
        return false;
    }

    @Override
    public boolean isClassical() {
        return this.getLeft().isClassical() && this.getRight().isClassical();
    }

    public boolean isGround() {
        return this.left.isGround() && this.right.isGround();
    }

    @Override
    public HashSet<BeliefAtom> getBeliefAtoms() {
        HashSet<BeliefAtom> beliefAtoms = (HashSet<BeliefAtom>) left.getBeliefAtoms().clone();
        beliefAtoms.addAll((HashSet<BeliefAtom>) right.getBeliefAtoms().clone());
//        beliefAtoms.add((BeliefAtom) left.getBeliefAtoms().clone());
//        beliefAtoms.add((BeliefAtom) right.getBeliefAtoms().clone());
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
            return new Disjunction(this.getLeft().convertToNNF(propogateStrongNegation),this.getRight().convertToNNF(propogateStrongNegation));
        } else {
            return new Conjunction(this.getLeft().convertToNNF(false), this.getRight().convertToNNF(false));
        }
    }

    @Override
    public boolean inNNF() {
        return this.getLeft().inNNF() && this.getRight().inNNF();
    }

    @Override
    public HashSet<HashSet<Terminal>> getSetClauses() throws UnsupportedOperationException {
        HashSet<HashSet<Terminal>> clauses = new HashSet<HashSet<Terminal>>();
        clauses.addAll(this.getLeft().getSetClauses());
        clauses.addAll(this.getRight().getSetClauses());
        return clauses;
    }

    @Override
    public HashSet<Terminal> getTerminals() throws UnsupportedOperationException {
        HashSet<Terminal> terminals = new HashSet<>();
        terminals.addAll(this.getLeft().getTerminals());
        terminals.addAll(this.getRight().getTerminals());
        return terminals;
    }

    @Override
    public Conjunction convertToCNF() throws Exception {
        return new Conjunction(this.getLeft().convertToCNF(), this.getRight().convertToCNF());
    }

    @Override
    public String toString() {
        return left.toString() + " && " + right.toString();
    }

}
