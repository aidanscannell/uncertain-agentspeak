package main.java.uncertain_agentspeak.uncertainty.epistemic_states.compact_epistemic_states;

import main.java.uncertain_agentspeak.agentspeak.logical_expressions.BeliefAtom;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.terminals.BeliefLiteral;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.terminals.primitives.Contradiction;
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
    public double getMinWeight() {
        return 0;
    }

    @Override
    public double getMaxWeight() {
        return 1;
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
            double alpha;
            Weight oldWeight = getPossibilityMeasure(beliefAtom);
            if (beliefLiteral.isPositive()) {
                alpha = Math.max(oldWeight.getPositive(), 1 - weight);
            } else {
                alpha = Math.max(1 - weight, oldWeight.getNegative());
            }
            if (beliefLiteral.getBeliefAtom().equals(beliefAtomDomain)) {
                if (beliefLiteral.isPositive()) {
                    w.setNegative(Math.min(w.getNegative(), Math.min(1-weight, alpha)));
                    w.setPositive(Math.min(w.getPositive(), alpha));
                } else {
                    w.setNegative(Math.min(w.getNegative(), alpha));
                    w.setPositive(Math.min(w.getPositive(),Math.min(1-weight, alpha)));
                }
            } else {

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

    @Override
    public double getLambda(BeliefLiteral beliefLiteral, HashSet<BeliefLiteral> boundedLiterals) throws Exception {
        HashSet<BeliefLiteral> boundedLiteralsCopy = (HashSet<BeliefLiteral>) boundedLiterals.clone();
        boundedLiteralsCopy.add(beliefLiteral);
        for (BeliefLiteral boundedLiteral : boundedLiterals) {
            if (boundedLiteralsCopy.contains(boundedLiteral.negation())) {
                return getLambda(new Contradiction(), boundedLiteralsCopy);
            }
        }
        return getPossibilityMeasure(beliefLiteral);
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
