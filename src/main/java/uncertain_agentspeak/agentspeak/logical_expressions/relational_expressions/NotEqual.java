package main.java.uncertain_agentspeak.agentspeak.logical_expressions.relational_expressions;

import main.java.uncertain_agentspeak.agentspeak.LogicalExpression;
import main.java.uncertain_agentspeak.agentspeak.Unifier;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.RelationalExpression;

public class NotEqual extends RelationalExpression {

    public NotEqual(LogicalExpression left, LogicalExpression right) {
        super(left, right);
    }

    public NotEqual substitute(Unifier unifier) throws Exception {
        return new NotEqual(super.getLeft().substitute(unifier), super.getRight().substitute(unifier));
    }

    @Override
    public RelationalExpression convertToNNF(boolean propogateStrongNegation) {
        if (propogateStrongNegation) {
            return new Equal(this.getLeft(),this.getRight());
        } else {
            return this;
        }
    }

    @Override
    public NotEqual convertToCNF() throws Exception {
        return new NotEqual(this.getLeft().convertToCNF(), this.getRight().convertToCNF());
    }

    @Override
    public String toString() {
        return super.getLeft().toString() + " \\= " + super.getRight().toString();
    }
}
