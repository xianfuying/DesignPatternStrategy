package com.movie;

import java.util.List;

public class Cinema {
    private Strategy strategy;

    public Cinema(Strategy strategy) {
        this.strategy = strategy;
    }

    public List<MovieTicket> buy(double money) {
        return strategy.buy(money);
    }
}