package com.movie;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private List<Strategy> strategies;

    public Cinema() {
        strategies = new ArrayList<Strategy>();

    }

    public Payment buy(int ticketCount) {
        if (strategies.isEmpty()) {
            return getDefaultPayment(ticketCount);
        }
        else {
            return getLowestPayment(ticketCount);
        }
    }

    private Payment getDefaultPayment(int ticketCount) {
        BasicStrategy defaultStrategy = new BasicStrategy();
        return defaultStrategy.buy(ticketCount);
    }

    private Payment getLowestPayment(int ticketCount) {
        Payment payment = new Payment();
        for (Strategy strategy : strategies) {
            payment = strategy.buy(ticketCount);
        }
        return payment;
    }

    public void support(Strategy strategy) {
        strategies.add(strategy);
    }

    public List<Strategy> getStrategies() {
        return strategies;
    }
}