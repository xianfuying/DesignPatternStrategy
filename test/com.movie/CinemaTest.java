package com.movie;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CinemaTest {
    private Cinema cinema;
    private Strategy strategy;

    @Before
    public void setUp() {
        cinema = new Cinema();
    }

    @Test
    public void should_support_basic_strategy() {
        strategy = new BasicStrategy();
        cinema.support(strategy);

        assertThat(cinema.getStrategies().contains(strategy), is(true));
    }

    @Test
    public void should_get_payment_with_100_dollar_using_cash_of_two_tickets() {
        strategy = new BasicStrategy();
        cinema.support(strategy);

        Payment payment = cinema.buy(2);

        assertThat(payment.toString(), is("Method: Cash\nTotal price: 100"));
    }

    @Test
    public void should_get_payment_with_100_dollar_using_cash_credit_card_of_two_tickets() {
        strategy = new CMBCStrategy();
        cinema.support(strategy);

        Payment payment = cinema.buy(2);

        assertThat(payment.toString(), is("Method: Credit Card\nTotal price: 50"));
    }

    @Test
    public void should_get_payment_with_50_dollar_of_two_tickets() {
        strategy = new TuesdayStrategy();
        cinema.support(strategy);

        Payment payment = cinema.buy(2);

        assertThat(payment.toString(), is("Method: Cash\nTotal price: 50"));
    }

    @Test
    public void should_get_payment_with_100_dollar_using_member_card_of_three_tickets() {
        strategy = new MemberStrategy();
        cinema.support(strategy);

        Payment payment = cinema.buy(3);

        assertThat(payment.toString(), is("Method: Member Card\nTotal price: 100"));
    }

    @Test
    public void should_get_payment_with_100_dollar_using_member_card_of_two_tickets(){
        strategy = new MemberStrategy();
        cinema.support(strategy);

        Payment payment = cinema.buy(2);

        assertThat(payment.toString(), is("Method: Member Card\nTotal price: 100"));
    }

    @Test
    public void should_get_payment_with_150_dollar_using_member_card_of_four_tickets(){
        strategy = new MemberStrategy();
        cinema.support(strategy);

        Payment payment = cinema.buy(4);

        assertThat(payment.toString(), is("Method: Member Card\nTotal price: 150"));
    }
}
