package main.uncertainty;

import main.agentspeak.LogicalExpression;
import main.agentspeak.Unifier;
import main.agentspeak.logical_expressions.BeliefAtom;
import main.agentspeak.logical_expressions.operators.Conjunction;
import main.agentspeak.logical_expressions.operators.Disjunction;
import main.agentspeak.logical_expressions.operators.GreaterEqualsPlausibility;
import main.agentspeak.logical_expressions.operators.GreaterThanPlausibility;
import main.agentspeak.logical_expressions.operators.negations.NegationAsFailure;
import main.agentspeak.logical_expressions.operators.negations.StrongNegation;
import main.agentspeak.logical_expressions.relational_expressions.Equal;
import main.agentspeak.logical_expressions.relational_expressions.NotEqual;
import main.agentspeak.logical_expressions.terminals.BeliefLiteral;
import main.agentspeak.logical_expressions.terminals.Primitive;
import main.agentspeak.logical_expressions.terminals.primitives.Contradiction;
import main.agentspeak.logical_expressions.terminals.primitives.Tautology;
import main.sat_solver.SATsolver;

import java.util.HashSet;

public abstract class EpistemicState {

    private HashSet<BeliefAtom> domain;

    public void setDomain(HashSet<BeliefAtom> domain) {
        this.domain = domain;
    }

    public HashSet<BeliefAtom> getDomain() {
        return domain;
    }

    public boolean languageContains(LogicalExpression logicalExpression) {
        for (BeliefAtom beliefAtom : logicalExpression.getBeliefAtoms()) {
            if (!languageContains(beliefAtom)) {
                return false;
            }
        }
        return true;
    }

    public boolean languageContains(BeliefAtom beliefAtom) {
        for (BeliefAtom beliefAtomDomain : domain) {
            Unifier unifier = beliefAtom.getTerm().unify(beliefAtomDomain.getTerm());
            if (unifier != null) {
                return true;
            }
        }
        return false;
    }

    public abstract double getLambda(LogicalExpression logicalExpression) throws Exception;

    public LogicalExpression pare(LogicalExpression logicalExpression) throws Exception {
        if (logicalExpression instanceof Conjunction) {
            return this.pare((Conjunction) logicalExpression);
        } else if (logicalExpression instanceof Disjunction) {
            return this.pare((Disjunction) logicalExpression);
        } else if (logicalExpression instanceof GreaterEqualsPlausibility) {
            return this.pare((GreaterEqualsPlausibility) logicalExpression);
        } else if (logicalExpression instanceof GreaterThanPlausibility) {
            return this.pare((GreaterThanPlausibility) logicalExpression);
        } else if (logicalExpression instanceof StrongNegation) {
            return this.pare((StrongNegation) logicalExpression);
        } else if (logicalExpression instanceof NegationAsFailure) {
            return this.pare((NegationAsFailure) logicalExpression);
        } else if (logicalExpression instanceof Equal) {
            return this.pare((Equal) logicalExpression);
        } else if (logicalExpression instanceof NotEqual) {
            return this.pare((NotEqual) logicalExpression);
        } else if (logicalExpression instanceof BeliefAtom) {
            return this.pare((BeliefAtom) logicalExpression);
        } else if (logicalExpression instanceof BeliefLiteral) {
            return this.pare((BeliefLiteral) logicalExpression);
        } else if (logicalExpression instanceof Contradiction) {
            return this.pare((Contradiction) logicalExpression);
        } else if (logicalExpression instanceof Tautology) {
            return this.pare((Tautology) logicalExpression);
        } else {
            throw new Exception("Formula not normalised");
        }
    }

    public Conjunction pare(Conjunction conjunction) throws Exception {
        return new Conjunction(this.pare(conjunction.getLeft()), this.pare(conjunction.getRight()));
    }

    public Disjunction pare(Disjunction disjunction) throws Exception {
        return new Disjunction(this.pare(disjunction.getLeft()), this.pare(disjunction.getRight()));
    }

    // TODO: Some formulas must have each operand as a classical formula
    public Primitive pare(GreaterEqualsPlausibility greaterEqualsPlausibility) throws Exception {
        double left = this.getLambda(new StrongNegation(greaterEqualsPlausibility.getLeft()));
        double right = this.getLambda(new StrongNegation(greaterEqualsPlausibility.getRight()));
        if (left <= right) {
            return new Tautology();
        } else {
            return new Contradiction();
        }
    }

    public Primitive pare(GreaterThanPlausibility greaterThanPlausibility) throws Exception {
        double left = this.getLambda(new StrongNegation(greaterThanPlausibility.getLeft()));
        double right = this.getLambda(new StrongNegation(greaterThanPlausibility.getRight()));
        if (left < right) {
            return new Tautology();
        } else {
            return new Contradiction();
        }
    }

    public StrongNegation pare(StrongNegation strongNegation) throws Exception {
        return new StrongNegation(this.pare(strongNegation.getTerm()));
    }

    public Primitive pare(NegationAsFailure negationAsFailure) throws Exception {
        if (this.getLambda(new StrongNegation(negationAsFailure.getTerm())) >= this.getLambda(negationAsFailure.getTerm())) {
            return new Tautology();
        } else {
            return new Contradiction();
        }
    }

    public Primitive pare(Equal equal) throws Exception {
        if (equal.getLeft().equals(equal.getRight())) {
            return new Tautology();
        } else {
            return new Contradiction();
        }
    }

    public Primitive pare(NotEqual notEqual) throws Exception {
        if (notEqual.getLeft() != notEqual.getRight()) {
            return new Tautology();
        } else {
            return new Contradiction();
        }
    }

    public BeliefAtom pare(BeliefAtom beliefAtom) throws Exception {
        return beliefAtom;
    }

    public BeliefLiteral pare(BeliefLiteral beliefLiteral) throws Exception {
        return beliefLiteral;
    }

    public Contradiction pare(Contradiction contradiction) throws Exception {
        return contradiction;
    }

    public Tautology pare(Tautology tautology) throws Exception {
        return tautology;
    }

    public Unifier entails(LogicalExpression logicalExpression) throws Exception {
        return entails(logicalExpression, new Unifier());
    }

    //TODO: check for NNF
    public Unifier entails(LogicalExpression logicalExpression, Unifier unifier) throws Exception {
        LogicalExpression groundLogicalExpression = logicalExpression.substitute(unifier);
        if (!domain.containsAll(groundLogicalExpression.getBeliefAtoms())) {
            return null;
        }
        LogicalExpression pare = pare(groundLogicalExpression).convertToNNF(false);
        LogicalExpression pareNegation = pare(new StrongNegation(groundLogicalExpression)).convertToNNF(false);
        double pareLambda = getLambda(pare);
        double pareLambdaNegation = getLambda(pareNegation);
        if (pareLambda > pareLambdaNegation) {
            return unifier;
        } else {
            return null;
        }
    }

}
