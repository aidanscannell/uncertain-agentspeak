package main.agentspeak;

import java.util.ArrayList;

public class BeliefBase extends ArrayList<Belief> {

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (Belief belief: this) {
            string.append("\t").append(belief.toString());
            if (belief != this.get(this.size()-1)) {
                string.append("\n");
            }
        }
        return string.toString();
    }

}
