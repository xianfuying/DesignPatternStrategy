package com.movie;

public class CouponStrategy implements Strategy{

    public static final int PRICE = 20;

    public Payment getPayment(int ticketCount) {
        Payment payment = new Payment();
        payment.setMethod("Coupon");
        payment.setPrice(ticketCount * PRICE);
        return payment;
    }
}
