package main.java.uncertain_agentspeak.uncertainty.epistemic_states;

public class Weight {

    private double positive;
    private double negative;

    public Weight(double positive, double negative) {
        this.positive = positive;
        this.negative = negative;
    }

    public double getPositive() {
        return positive;
    }

    public double getNegative() {
        return negative;
    }

    public void setPositive(double positive) {
        this.positive = positive;
    }

    public void setNegative(double negative) {
        this.negative = negative;
    }

    public void addPositive(double positive) {
        this.positive += positive;
    }

    public void addNegative(double negative) {
        this.negative += negative;
    }

    public void add(Weight weight) {
        this.positive += weight.positive;
        this.negative += weight.negative;
    }

    public double max() {
        if (this.positive >= this.negative) {
            return this.positive;
        } else {
            return this.negative;
        }
    }

    public Weight copy() {
        return new Weight(this.positive, this.negative);
    }

    @Override
    public String toString() {
        return "(" + positive + ", " + negative + ")";
    }
}
