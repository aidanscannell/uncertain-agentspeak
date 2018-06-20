package main.uncertainty.epistemic_states;

import main.agentspeak.logical_expressions.BeliefAtom;
import main.agentspeak.logical_expressions.terminals.BeliefLiteral;
import main.uncertainty.EpistemicState;

import java.util.HashMap;
import java.util.HashSet;

public class PossibilisticEpistemicState extends EpistemicState {

    public PossibilisticEpistemicState(HashSet<BeliefAtom> atoms) throws Exception {
        super(atoms);
    }

    @Override
    public Weight getInitialWeight() {
        return new Weight(1, 1);
    }

    @Override
    public void revise(BeliefLiteral beliefLiteral, double weight) throws Exception {
        BeliefAtom beliefAtom = beliefLiteral.getBeliefAtom();


    }

}
