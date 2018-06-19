package main.uncertainty.epistemic_states;

import main.agentspeak.logical_expressions.BeliefAtom;
import main.uncertainty.EpistemicState;

import java.util.HashMap;
import java.util.HashSet;

public class PossibilisticEpistemicState extends EpistemicState {

    public PossibilisticEpistemicState(HashSet<BeliefAtom> atoms) throws Exception {
        super(atoms);
    }
}
