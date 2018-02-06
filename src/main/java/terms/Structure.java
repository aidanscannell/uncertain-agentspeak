package main.java.terms;

import java.util.List;
import main.java.Term;
import main.java.terms.constants.Atom;

public class Structure extends Term {

    private Atom functor;
    private List<Term> arguments;
    private int arity;

    public Structure(Atom functor, List<Term> arguments){
        this.functor = functor;
        this.arguments = arguments;
        this.arity = arguments.size();
    }

    public Atom getFunctor() {
        return functor;
    }

    public List<Term> getArguments() {
        return arguments;
    }

    public int getArity(){
        return arity;
    }


}
