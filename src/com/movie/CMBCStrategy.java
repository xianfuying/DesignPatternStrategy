package com.movie;

import java.util.List;

public class CMBCStrategy implements Strategy {

    private static final int PRICE = 25;

    public List<MovieTicket> buy(double money) {
        return TicketCreator.getTickets(money / PRICE);
    }
}
