package main.uncertainty;

import java.util.HashSet;

public class GlobalUncertainBelief {

    private HashSet<EpistemicState> GUB;

    public void addEpistemicState(EpistemicState epistemicState) {
        this.GUB.add(epistemicState);
    }

    public HashSet<EpistemicState> getGUB() {
        return GUB;
    }
}
