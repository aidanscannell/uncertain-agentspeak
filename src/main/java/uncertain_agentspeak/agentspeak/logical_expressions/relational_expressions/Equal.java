package main.java.uncertain_agentspeak.agentspeak.logical_expressions.relational_expressions;

import main.java.uncertain_agentspeak.agentspeak.LogicalExpression;
import main.java.uncertain_agentspeak.agentspeak.Unifier;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.RelationalExpression;

public class Equal extends RelationalExpression {

    public Equal(LogicalExpression left, LogicalExpression right) {
        super(left, right);
    }

    public Equal substitute(Unifier unifier) throws Exception {
        return new Equal(super.getLeft().substitute(unifier), super.getRight().substitute(unifier));
    }

    @Override
    public RelationalExpression convertToNNF(boolean propogateStrongNegation) {
        if (propogateStrongNegation) {
            return new NotEqual(this.getLeft(),this.getRight());
        } else {
            return this;
        }
    }

    @Override
    public Equal convertToCNF() throws Exception {
        return new Equal(this.getLeft().convertToCNF(), this.getRight().convertToCNF());
    }

    @Override
    public String toString() {
        return super.getLeft().toString() + " == " + super.getRight().toString();
    }
}
