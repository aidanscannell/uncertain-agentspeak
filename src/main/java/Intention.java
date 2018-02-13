package main.java;

import java.util.ArrayDeque;
import java.util.Deque;

public class Intention {

    private Deque<IntendedMeans> intendedMeans;

    public Intention(){
        this.intendedMeans = new ArrayDeque<IntendedMeans>();
    }

    public IntendedMeans pop(){
        return intendedMeans.pop();
    }

    public void push(IntendedMeans intendedMeans){
        this.intendedMeans.push(intendedMeans);
    }

}
