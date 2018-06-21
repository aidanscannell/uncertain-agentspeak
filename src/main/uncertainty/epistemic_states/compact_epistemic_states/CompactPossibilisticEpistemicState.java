package main.uncertainty.epistemic_states.compact_epistemic_states;

import main.agentspeak.logical_expressions.BeliefAtom;
import main.agentspeak.logical_expressions.terminals.BeliefLiteral;
import main.uncertainty.epistemic_states.CompactEpistemicState;
import main.uncertainty.epistemic_states.Weight;

import java.util.HashMap;
import java.util.HashSet;

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
    public void revise(BeliefLiteral beliefLiteral, double weight) throws Exception {
        BeliefAtom beliefAtom = beliefLiteral.getBeliefAtom();

        if (!this.getDomain().contains(beliefAtom)) {
            throw new Exception("Belief atom is not in domain");
        }

        

    }

}
