package com.movie;

import java.util.List;

public class MemberStrategy implements Strategy {

    private static final int PRICE = 50;

    public List<MovieTicket> buy(double money) {
        int count = (int) (money / PRICE);
        count = (count / 2) * 3 + count % 2;
        return TicketCreator.getTickets(count);
    }
}
