package main.uncertainty.epistemic_states.compact_epistemic_states;

import main.agentspeak.logical_expressions.BeliefAtom;
import main.agentspeak.logical_expressions.operators.Conjunction;
import main.agentspeak.logical_expressions.terminals.BeliefLiteral;
import main.agentspeak.logical_expressions.terminals.primitives.Contradiction;
import main.uncertainty.epistemic_states.CompactEpistemicState;
import main.uncertainty.epistemic_states.Weight;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class CompactProbabilisticEpistemicState extends CompactEpistemicState {

    public CompactProbabilisticEpistemicState(HashSet<BeliefAtom> atoms) throws Exception {
        super(atoms);
    }

    public double getMinWeight() {
        return 0;
    }

    public double getMaxWeight() {
        return 1;
    }

    @Override
    public Weight getInitialWeight() {
        return new Weight(0.5, 0.5);
    }

    @Override
    public void revise(BeliefLiteral beliefLiteral, double weight) throws Exception {
        BeliefAtom beliefAtom = beliefLiteral.getBeliefAtom();

        if (!super.getDomain().contains(beliefAtom)) {
            throw new Exception("Belief atom is not in domain");
        }
        if (!super.getDomain().contains(beliefAtom)) {
            Weight w = this.getWeightedBeliefBase().get(beliefAtom);
            if (beliefLiteral.isPositive()) {
                w.setPositive(weight);
                w.setNegative(this.getMaxWeight() - weight);
            } else {
                w.setNegative(weight);
                w.setPositive(this.getMaxWeight() - weight);
            }
            if (w.equals(this.getWeightedBeliefBase().get(beliefAtom))) {
                this.getWeightedBeliefBase().remove(beliefAtom);
            } else {
                this.getWeightedBeliefBase().put(beliefAtom, w);
            }
        } else {
            Weight w = this.getInitialWeight().copy();
            if (beliefLiteral.isPositive()) {
                w.setPositive(weight);
                w.setNegative(this.getMaxWeight() - weight);
            } else {
                w.setPositive(this.getMaxWeight() - weight);
                w.setNegative(weight);
            }
            this.getWeightedBeliefBase().put(beliefAtom, w);
        }
    }

    public double getProbability(BeliefLiteral beliefLiteral) throws Exception {
        return this.getWeight(beliefLiteral);
    }

    public double getLambda(BeliefLiteral beliefLiteral) throws Exception {
        return this.getProbability(beliefLiteral);
    }

//    public double getLambda(Conjunction conjunction) throws Exception {
//        return this.getLambda(conjunction.getLeft())
//    }

    @Override
    public String toString() {
        String string = "{ ";
        Iterator it = this.getWeightedBeliefBase().entrySet().iterator();
//        System.out.println(this.getDomain().toString());
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            string += "P(" + pair.getKey().toString() + ")=" + pair.getValue().toString();
            if (it.hasNext()) {
                string += ", ";
            }
//            it.remove(); // avoids a ConcurrentModificationException
        }
        string += " }";
        return string;
    }
}
