package com.movie;

import java.util.List;

public class BasicStrategy implements Strategy{

    private static final int PRICE = 50;

    public List<MovieTicket> buy(double money) {
        return TicketCreator.getTickets(money / PRICE);
    }
}
