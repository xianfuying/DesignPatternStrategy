package com.movie;

public class TuesdayStrategy implements Strategy {

    private static final int PRICE = 25;

    public Payment buy(int ticketCount) {
        Payment payment = new Payment();
        payment.setMethod("Cash");
        payment.setPrice(ticketCount * PRICE);
        return payment;
    }
}
