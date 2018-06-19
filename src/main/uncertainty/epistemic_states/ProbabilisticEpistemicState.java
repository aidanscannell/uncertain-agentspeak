package main.uncertainty.epistemic_states;

import main.agentspeak.logical_expressions.BeliefAtom;
import main.agentspeak.logical_expressions.terminals.BeliefLiteral;
import main.uncertainty.EpistemicState;

import java.util.HashSet;

public class ProbabilisticEpistemicState extends EpistemicState {

    public ProbabilisticEpistemicState(HashSet<BeliefAtom> atoms) throws Exception {
        super(atoms);
    }

    public double getMinWeight() {
        return 0;
    }

    public double getMaxWeight() {
        return 1;
    }

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
            Weight w = this.getWeightedBeliefBase().get(beliefAtom);
            if (beliefLiteral.isPositive()) {
                w.setPositive(weight);
                w.setNegative(this.getMaxWeight() - weight);
            } else {
                w.setNegative(weight);
                w.setPositive(this.getMaxWeight() - weight);
            }
            this.getWeightedBeliefBase().put(beliefAtom, w);
        }
    }
}
