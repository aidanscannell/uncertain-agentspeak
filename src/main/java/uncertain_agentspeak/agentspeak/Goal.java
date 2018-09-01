package main.java.uncertain_agentspeak.agentspeak;

public abstract class Goal {

    private Term term;
    private LogicalExpression formula;

    public Goal(Term term) {
        this.term = term;
    }

    public Goal(LogicalExpression formula) {
        this.formula = formula;
    }

    public Term getTerm() {
        return term;
    }

    public LogicalExpression getFormula() {
        return formula;
    }

    public abstract Goal substitute(Unifier unifier) throws Exception;

}
