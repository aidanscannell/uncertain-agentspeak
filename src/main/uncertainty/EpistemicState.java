package main.uncertainty;

import main.exceptions.NotGroundException;
import main.agentspeak.logical_expressions.BeliefAtom;
import main.uncertainty.epistemic_states.Weight;

import java.util.HashMap;
import java.util.HashSet;

public class EpistemicState {

    private HashMap<BeliefAtom, Weight> weightedBeliefBase;
    private HashSet<BeliefAtom> domain;

    public EpistemicState(HashSet<BeliefAtom> domain) throws NotGroundException {
        for (BeliefAtom d : domain) {
            if (!d.isGround()) {
                throw new NotGroundException("The belief atoms in the domain must be ground");
            }
        }
        this.domain = domain;
        this.weightedBeliefBase = new HashMap<BeliefAtom, Weight>();
    }

    public HashSet<BeliefAtom> getDomain() {
        return domain;
    }

        public HashMap<BeliefAtom, Weight> getWeightedBeliefBase() {
        return weightedBeliefBase;
    }
}
