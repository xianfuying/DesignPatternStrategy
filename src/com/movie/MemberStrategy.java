package com.movie;

public class MemberStrategy implements Strategy {

    private static final int PRICE = 50;

    public Payment buy(int ticketCount) {
        Payment payment = new Payment();
        payment.setMethod("Member Card");
        int count = getTicketCountNeedToPay(ticketCount);
        payment.setPrice(count * PRICE);
        return payment;
    }

    private int getTicketCountNeedToPay(int ticketCount) {
        return (ticketCount / 3) * 2 + ticketCount % 3;
    }
}
