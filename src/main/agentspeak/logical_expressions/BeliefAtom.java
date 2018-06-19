package main.agentspeak.logical_expressions;

import main.agentspeak.LogicalExpression;
import main.agentspeak.Term;

public class BeliefAtom extends LogicalExpression {

    private Term belief;

    public BeliefAtom(Term belief) {
        this.belief = belief;
    }

    public Term getTerm() {
        return belief;
    }

    @Override
    public boolean isGround() {
        return belief.isGround();
    }

}
