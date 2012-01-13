package com.movie;

public class Consumer {
    public static void main(String[] args) {
        Strategy memberStrategy = new MemberStrategy();
        CMBCStrategy cmbcStrategy = new CMBCStrategy();

        Cinema cinema = new Cinema();
        cinema.support(memberStrategy);
        cinema.support(cmbcStrategy);

        Payment payment = cinema.askForPrice(5);

        System.out.println(payment);
    }
}
