package com.movie;

public class CMBCStrategy implements Strategy {

    private static final int PRICE = 25;

    public Payment getPayment(int ticketCount) {
        Payment payment = new Payment();
        payment.setMethod("Credit Card");
        payment.setPrice(ticketCount * PRICE);
        return payment;
    }
}
