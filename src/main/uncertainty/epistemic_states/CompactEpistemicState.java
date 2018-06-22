package main.uncertainty.epistemic_states;

import com.oracle.tools.packager.Log;
import main.agentspeak.Belief;
import main.agentspeak.LogicalExpression;
import main.agentspeak.logical_expressions.operators.Conjunction;
import main.agentspeak.logical_expressions.operators.Disjunction;
import main.agentspeak.logical_expressions.terminals.BeliefLiteral;
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

//    public double getLambda(LogicalExpression logicalExpression) throws Exception {
//        if (!logicalExpression.isGround()) {
//            throw new Exception("Formula is not ground");
//        }
//
//    }

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

    public double getLambda(Contradiction contradiction, HashSet<BeliefLiteral> boundedLiterals) {
        return this.getMinWeight();
    }

    public double getLambda(Tautology tautology, HashSet<BeliefLiteral> boundedLiterals) {
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


//    @Override
//    public String toString() {
//        String string = "{";
//        Iterator it = weightedBeliefBase.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry pair = (Map.Entry)it.next();
//            string += "[" + pair.getKey().toString() + ", " + pair.getValue().toString() + "]";
//            if (it.hasNext()) {
//                string += ", ";
//            }
//            it.remove(); // avoids a ConcurrentModificationException
//        }
//        string += "}";
//        return string;
//    }
}
