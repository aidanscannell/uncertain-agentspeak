package main.agentspeak.logical_expressions.operators;

import main.agentspeak.LogicalExpression;
import main.agentspeak.Unifier;
import main.agentspeak.logical_expressions.BeliefAtom;
import main.agentspeak.logical_expressions.Operator;
import main.agentspeak.logical_expressions.terminals.BeliefLiteral;

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

    public Conjunction substitute(Unifier unifier) {
        return new Conjunction(this.getLeft().substitute(unifier), this.getRight().substitute(unifier));
    }

    public boolean isConjunctive() {
        if (this.getLeft().isConjunctive() && this.getRight().isConjunctive()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isDisjunctive() {
        return false;
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
    public Operator convertToNNF(boolean propogateStrongNegation) {
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
    public String toString() {
        return left.toString() + " && " + right.toString();
    }

}
