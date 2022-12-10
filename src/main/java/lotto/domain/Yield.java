package lotto.domain;

public class Yield {
    private double yield;

    public Yield(double yield) {
        this.yield = yield;
    }

    public double getYield() {
        return yield;
    }

    @Override
    public String toString() {
        return "Yield{" +
                "yield=" + yield +
                '}';
    }
}
