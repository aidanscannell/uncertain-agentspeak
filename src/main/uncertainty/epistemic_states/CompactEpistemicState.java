package main.uncertainty.epistemic_states;

import com.oracle.tools.packager.Log;
import main.agentspeak.Belief;
import main.agentspeak.LogicalExpression;
import main.agentspeak.logical_expressions.operators.*;
import main.agentspeak.logical_expressions.operators.negations.NegationAsFailure;
import main.agentspeak.logical_expressions.operators.negations.StrongNegation;
import main.agentspeak.logical_expressions.relational_expressions.Equal;
import main.agentspeak.logical_expressions.relational_expressions.NotEqual;
import main.agentspeak.logical_expressions.terminals.BeliefLiteral;
import main.agentspeak.logical_expressions.terminals.Primitive;
import main.agentspeak.logical_expressions.terminals.belief_literals.NegativeLiteral;
import main.agentspeak.logical_expressions.terminals.belief_literals.PositiveLiteral;
import main.agentspeak.logical_expressions.terminals.primitives.Contradiction;
import main.agentspeak.logical_expressions.terminals.primitives.Tautology;
import main.exceptions.NotGroundException;
import main.agentspeak.logical_expressions.BeliefAtom;
import main.uncertainty.EpistemicState;
import main.uncertainty.epistemic_states.Weight;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class CompactEpistemicState extends EpistemicState {

    private HashSet<BeliefAtom> domain;
    private HashMap<BeliefAtom, Weight> weightedBeliefBase;
    private double totalWeight;

    private final Weight initialWeight = new Weight(0,0);

    public CompactEpistemicState(HashSet<BeliefAtom> domain) throws NotGroundException {
        for (BeliefAtom d : domain) {
            if (!d.isGround()) {
                throw new NotGroundException("The belief atoms in the domain must be ground");
            }
        }
        this.domain = domain;
        this.weightedBeliefBase = new HashMap<BeliefAtom, Weight>();
        this.totalWeight = 0;
    }

    public HashSet<BeliefAtom> getDomain() {
        return domain;
    }

    public HashMap<BeliefAtom, Weight> getWeightedBeliefBase() {
        return weightedBeliefBase;
    }

    public Weight getInitialWeight() {
        return initialWeight;
    }

    public double getMinWeight() {
        return Double.NEGATIVE_INFINITY;
    }

    public double getMaxWeight() {
        return this.totalWeight;
    }

    public void revise(BeliefLiteral beliefLiteral, double weight) throws Exception {
        BeliefAtom beliefAtom = beliefLiteral.getBeliefAtom();

        if (!this.getDomain().contains(beliefAtom)) {
            throw new Exception("Belief atom no in domain");
        }

        if (weightedBeliefBase.containsKey(beliefAtom)) {
            Weight oldWeight = this.getWeightedBeliefBase().get(beliefAtom);
            totalWeight -= oldWeight.max();
            if (beliefLiteral.isPositive()) {
                oldWeight.addPositive(weight);
            } else {
                oldWeight.addNegative(weight);
            }
            if (oldWeight.equals(this.getInitialWeight())) {
                weightedBeliefBase.remove(beliefAtom);
            } else {
                weightedBeliefBase.put(beliefAtom, oldWeight);
                totalWeight += oldWeight.max();
            }
        } else {
            Weight newWeight = getInitialWeight().copy();
            if (beliefLiteral.isPositive()) {
                newWeight.addPositive(weight);
            } else {
                newWeight.addNegative(weight);
            }
            weightedBeliefBase.put(beliefAtom, newWeight);
            totalWeight += newWeight.max();
        }
    };

    public Weight getWeight(BeliefAtom beliefAtom) throws Exception {
        if (this.domain.contains(beliefAtom)) {
            if (this.weightedBeliefBase.containsKey(beliefAtom)) {
                return this.weightedBeliefBase.get(beliefAtom);
            } else {
                return getInitialWeight().copy();
            }
        } else {
            throw new Exception("Belief atom not contained in domain");
        }
    }

    public double getWeight(BeliefLiteral beliefLiteral) throws Exception {
        if (beliefLiteral.isPositive()) {
            return getWeight((PositiveLiteral) beliefLiteral);
        } else {
            return getWeight((NegativeLiteral) beliefLiteral);
        }
    }

    public double getWeight(PositiveLiteral positiveLiteral) throws Exception {
        BeliefAtom beliefAtom = positiveLiteral.getBeliefAtom();
        if (this.domain.contains(beliefAtom)) {
            if (this.weightedBeliefBase.containsKey(beliefAtom)) {
                return this.weightedBeliefBase.get(positiveLiteral.getBeliefAtom()).getPositive();
            } else {
                return this.getInitialWeight().getPositive();
            }
        } else {
            throw new Exception("Belief atom not contained in domain");
        }
    }

    public double getWeight(NegativeLiteral negativeLiteral) throws Exception {
        BeliefAtom beliefAtom = negativeLiteral.getBeliefAtom();
        if (this.domain.contains(beliefAtom)) {
            if (this.weightedBeliefBase.containsKey(beliefAtom)) {
                return this.weightedBeliefBase.get(negativeLiteral.getBeliefAtom()).getNegative();
            } else {
                return this.getInitialWeight().getPositive();
            }
        } else {
            throw new Exception("Belief atom not contained in domain");
        }
    }

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
        } else if (logicalExpression instanceof  NegationAsFailure) {
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
        if (equal.getLeft() == equal.getRight()) {
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

    public double getLambda(LogicalExpression logicalExpression) throws Exception {
        if (!logicalExpression.isGround()) {
            throw new Exception("Formula is not ground");
        }
        LogicalExpression formula = this.pare(logicalExpression);
        return this.getLambda(formula, new HashSet<BeliefLiteral>());
    }

    public double getLambda(LogicalExpression logicalExpression, HashSet<BeliefLiteral> boundedLiterals) throws Exception {
        if (logicalExpression instanceof BeliefLiteral){
            return this.getLambda((BeliefLiteral) logicalExpression, boundedLiterals);
        } else if (logicalExpression instanceof Conjunction) {
            return this.getLambda((Conjunction) logicalExpression, boundedLiterals);
        } else if (logicalExpression instanceof Disjunction) {
            return this.getLambda((Disjunction) logicalExpression, boundedLiterals);
        } else if (logicalExpression instanceof Contradiction) {
            return this.getLambda((Contradiction) logicalExpression, boundedLiterals);
        } else if (logicalExpression instanceof Tautology) {
            return this.getLambda((Tautology) logicalExpression, boundedLiterals);
        } else if (logicalExpression instanceof NegationAsFailure) {
            return this.getLambda((NegationAsFailure) logicalExpression, boundedLiterals);
        } else if (logicalExpression instanceof GreaterEqualsPlausibility) {
            return this.getLambda((GreaterEqualsPlausibility) logicalExpression, boundedLiterals);
        } else if (logicalExpression instanceof GreaterThanPlausibility) {
            return this.getLambda((GreaterThanPlausibility) logicalExpression, boundedLiterals);
        } else if (logicalExpression instanceof Equal) {
            return this.getLambda((Equal) logicalExpression, boundedLiterals);
        } else if (logicalExpression instanceof NotEqual) {
            return this.getLambda((NotEqual) logicalExpression, boundedLiterals);
        } else {
            throw new Exception("Formula not normalised");
        }
    }

    public double getLambda(BeliefLiteral beliefLiteral, HashSet<BeliefLiteral> boundedLiterals) throws Exception {
        HashSet<BeliefLiteral> copyBoundedLiterals = (HashSet<BeliefLiteral>) boundedLiterals.clone();
        copyBoundedLiterals.add(beliefLiteral);
        double sum = 0;
        for (BeliefLiteral boundedLiteral : boundedLiterals){
            if (copyBoundedLiterals.contains(boundedLiteral.negation())) {
                return this.getLambda(new Contradiction(), copyBoundedLiterals);
            } else {
                Weight weight = this.getWeight(boundedLiteral.getBeliefAtom());
                if (boundedLiteral.isPositive()) {
                    sum += Math.abs(weight.getPositive() - weight.max());
                } else {
                    sum += Math.abs(weight.getNegative() - weight.max());
                }
            }
        }
        return this.getMaxWeight() - sum;
    }

    public double getLambda(Contradiction contradiction, HashSet<BeliefLiteral> boundedLiterals) throws Exception {
        return this.getMinWeight();
    }

    public double getLambda(Tautology tautology, HashSet<BeliefLiteral> boundedLiterals) throws Exception {
        return this.getMaxWeight();
    }

    public double getLambda(Conjunction conjunction, HashSet<BeliefLiteral> boundedLiterals) throws Exception {
        HashSet<BeliefLiteral> copyBoundedLiterals = (HashSet<BeliefLiteral>) boundedLiterals.clone();
        if (conjunction.getLeft().isConjunctive() && conjunction.getRight().isDisjunctive()) {
            copyBoundedLiterals.addAll(conjunction.getLeft().getBeliefLiterals());
            return this.getLambda(conjunction.getRight(), copyBoundedLiterals);
        } else if (conjunction.getLeft().isDisjunctive() && conjunction.getRight().isConjunctive()) {
            copyBoundedLiterals.addAll(conjunction.getRight().getBeliefLiterals());
            return this.getLambda(conjunction.getRight(), copyBoundedLiterals);
        } else {
            throw new Exception("Formula not in language " + this);
        }
    }

    public double getLambda(Disjunction disjunction, HashSet<BeliefLiteral> boundedLiterals) throws Exception {
        double left = this.getLambda(disjunction.getLeft(), boundedLiterals);
        double right = this.getLambda(disjunction.getRight(), boundedLiterals);
        if (left >= right) {
            return left;
        } else {
            return right;
        }
    }

    public double getLambda(NegationAsFailure negationAsFailure, HashSet<BeliefLiteral> boundedLiterals) throws Exception {
        return this.getLambda(this.pare(negationAsFailure), boundedLiterals);
    }

    public double getLambda(GreaterEqualsPlausibility greaterEqualsPlausibility, HashSet<BeliefLiteral> boundedLiterals) throws Exception {
        return this.getLambda(this.pare(greaterEqualsPlausibility), boundedLiterals);
    }

    public double getLambda(GreaterThanPlausibility greaterThanPlausibility, HashSet<BeliefLiteral> boundedLiterals) throws Exception {
        return this.getLambda(this.pare(greaterThanPlausibility), boundedLiterals);
    }

    public double getLambda(Equal equal, HashSet<BeliefLiteral> boundedLiterals) throws Exception {
        return this.getLambda(this.pare(equal), boundedLiterals);
    }

    public double getLambda(NotEqual notEqual, HashSet<BeliefLiteral> boundedLiterals) throws Exception {
        return this.getLambda(this.pare(notEqual), boundedLiterals);
    }


    @Override
    public String toString() {
        String string = "{";
        Iterator it = weightedBeliefBase.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            string += "[" + pair.getKey().toString() + ", " + pair.getValue().toString() + "]";
            if (it.hasNext()) {
                string += ", ";
            }
            it.remove(); // avoids a ConcurrentModificationException
        }
        string += "}";
        return string;
    }
}
