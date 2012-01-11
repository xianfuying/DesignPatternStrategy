package com.movie;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private List<Strategy> strategies;
    private Strategy defaultStrategy;

    public Cinema() {
        strategies = new ArrayList<Strategy>();
        defaultStrategy = new BasicStrategy();
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
        return defaultStrategy.buy(ticketCount);
    }

    private Payment getLowestPayment(int ticketCount) {
        Payment payment = getDefaultPayment(ticketCount);
        for (Strategy strategy : strategies) {
            payment = getLowerPayment(payment, strategy.buy(ticketCount));
        }
        return payment;
    }

    private Payment getLowerPayment(Payment payment, Payment paymentToCompare) {
        if (paymentToCompare.noBiggerThan(payment)) {
            payment = paymentToCompare;
        }
        return payment;
    }

    public void support(Strategy strategy) {
        strategies.add(strategy);
    }

    protected List<Strategy> getStrategies() {
        return strategies;
    }

    protected Strategy getDefaultStrategy() {
        return defaultStrategy;
    }
}