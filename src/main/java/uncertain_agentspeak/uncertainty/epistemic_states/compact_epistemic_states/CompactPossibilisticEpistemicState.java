package main.java.uncertain_agentspeak.uncertainty.epistemic_states.compact_epistemic_states;

import main.java.uncertain_agentspeak.agentspeak.LogicalExpression;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.BeliefAtom;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.operators.Conjunction;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.operators.Disjunction;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.terminals.BeliefLiteral;
import main.java.uncertain_agentspeak.uncertainty.epistemic_states.CompactEpistemicState;
import main.java.uncertain_agentspeak.uncertainty.epistemic_states.Weight;

import java.util.HashMap;
import java.util.HashSet;
import java.lang.*;
import java.util.Iterator;
import java.util.Map;

public class CompactPossibilisticEpistemicState extends CompactEpistemicState {

    public CompactPossibilisticEpistemicState(HashSet<BeliefAtom> atoms) throws Exception {
        super(atoms);
    }

    @Override
    public HashSet<BeliefAtom> getDomain() {
        return super.getDomain();
    }

    @Override
    public HashMap<BeliefAtom, Weight> getWeightedBeliefBase() {
        return super.getWeightedBeliefBase();
    }

    @Override
    public Weight getInitialWeight() {
        return new Weight(1, 1);
    }

    @Override
    /** Revise as N(beliefLiteral) >= weight **/
    public void revise(BeliefLiteral beliefLiteral, double weight) throws Exception {
        BeliefAtom beliefAtom = beliefLiteral.getBeliefAtom();

        if (!this.getDomain().contains(beliefAtom)) {
            throw new Exception("Belief atom is not in domain");
        }

        for (BeliefAtom beliefAtomDomain : this.getDomain()) {

            /** If belief atom in domain revise it's corresponding weight, otherwise revise initial probabilistic weight
             * **/
            Weight w;
            if (this.getWeightedBeliefBase().containsKey(beliefAtomDomain)) {
                w = this.getWeightedBeliefBase().get(beliefAtomDomain);
            } else {
                w = this.getInitialWeight().copy();
            }

            /** Check if the belief literal equals the domain belief atom, if it is positive or negative and then
             * revise accordingly
             * **/
            if (beliefLiteral.getBeliefAtom().equals(beliefAtomDomain)) {
                if (beliefLiteral.isPositive()) {
                    w.setNegative(Math.min(w.getNegative(),1-weight));
                } else {
                    w.setPositive(Math.min(w.getPositive(),1-weight));
                }
            } else {
                double alpha;
                if (beliefLiteral.isPositive()) {
                    alpha = Math.max(w.getPositive(), 1 - weight);
                } else {
                    alpha = Math.max(1 - weight, w.getNegative());
                }
                w.setPositive(Math.min(w.getPositive(),alpha));
                w.setNegative(Math.min(w.getNegative(),alpha));
            }

            /** If the atom is contained in the weighted belief base and it's revised weight is equal to the initial
             * possibilistic weight then remove it from the weighted belief base, otherwise put the belief atom and
             * its associated weight into the weighted belief base.
             * **/
            if (w.equals(this.getInitialWeight())) {
                this.getWeightedBeliefBase().remove(beliefAtomDomain);
            } else {
                this.getWeightedBeliefBase().put(beliefAtomDomain, w);
            }
        }
    }

    public Weight getPossibilityMeasure(BeliefAtom beliefAtom) throws Exception {
        return this.getWeight(beliefAtom);
    }

    public double getPossibilityMeasure(BeliefLiteral beliefLiteral) throws Exception {
        return this.getWeight(beliefLiteral);
    }

    public double getLambda(BeliefAtom beliefAtom) {
        return this.getWeightedBeliefBase().get(beliefAtom).getPositive();
    }

    @Override
    public double getLambda(BeliefLiteral beliefLiteral, HashSet<BeliefLiteral> beliefLiterals) throws Exception {
        BeliefAtom beliefAtom = beliefLiteral.getBeliefAtom();
        if (beliefLiteral.isPositive()) {
            return this.getWeightedBeliefBase().get(beliefAtom).getPositive();
        } else {
            return this.getWeightedBeliefBase().get(beliefAtom).getNegative();
        }
    }

    public double getLambda(Conjunction conjunction) throws Exception {
        return Math.max(this.getLambda(conjunction.getLeft()), this.getLambda(conjunction.getRight()));
    }

    public double getLambda(Disjunction disjunction) throws Exception {
        return Math.min(this.getLambda(disjunction.getLeft()), this.getLambda(disjunction.getRight()));
    }

    @Override
    public String toString() {
        String string = "{ ";
        Iterator it = this.getWeightedBeliefBase().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            string += "\n\t\t\tPi( " + pair.getKey().toString() + ", " + pair.getValue().toString() + " )";
            if (it.hasNext()) {
                string += ", ";
            }
        }
        string += " \n\t\t}";
        return string;
    }

}
