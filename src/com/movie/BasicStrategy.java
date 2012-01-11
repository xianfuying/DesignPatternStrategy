package com.movie;

public class BasicStrategy implements Strategy{

    private static final int PRICE = 50;

    public Payment getPayment(int ticketCount) {
        Payment payment = new Payment();
        payment.setMethod("Cash");
        payment.setPrice(ticketCount * PRICE);
        return payment;
    }
}
