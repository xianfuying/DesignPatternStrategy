package com.movie;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
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
        strategy = new MemberStrategy();
        cinema.support(strategy);

        assertThat(cinema.hasStrategy(strategy), is(true));
    }

    @Test
    public void should_set_basic_strategy_as_default_strategy(){
        assertThat(cinema.getDefaultStrategy(), is(instanceOf(CashStrategy.class)));
    }

    @Test
    public void should_get_payment_with_100_dollar_using_cash_of_two_tickets() {
        Payment payment = cinema.askForPrice(2);

        assertThat(payment.toString(), is("Method: Cash\nTotal price: 100"));
    }

    @Test
    public void should_get_payment_with_100_dollar_using_cash_credit_card_of_two_tickets() {
        strategy = new CMBCStrategy();
        cinema.support(strategy);

        Payment payment = cinema.askForPrice(2);

        assertThat(payment.toString(), is("Method: Credit Card\nTotal price: 50"));
    }

    @Test
    public void should_get_payment_with_50_dollar_of_two_tickets() {
        strategy = new TuesdayStrategy();
        cinema.support(strategy);

        Payment payment = cinema.askForPrice(2);

        assertThat(payment.toString(), is("Method: Cash\nTotal price: 50"));
    }

    @Test
    public void should_get_payment_with_100_dollar_using_member_card_of_three_tickets() {
        strategy = new MemberStrategy();
        cinema.support(strategy);

        Payment payment = cinema.askForPrice(3);

        assertThat(payment.toString(), is("Method: Member Card\nTotal price: 100"));
    }

    @Test
    public void should_get_payment_with_100_dollar_using_member_card_of_two_tickets(){
        strategy = new MemberStrategy();
        cinema.support(strategy);

        Payment payment = cinema.askForPrice(2);

        assertThat(payment.toString(), is("Method: Member Card\nTotal price: 100"));
    }

    @Test
    public void should_get_payment_with_150_dollar_using_member_card_of_four_tickets(){
        strategy = new MemberStrategy();
        cinema.support(strategy);

        Payment payment = cinema.askForPrice(4);

        assertThat(payment.toString(), is("Method: Member Card\nTotal price: 150"));
    }

    @Test
    public void should_get_lowest_payment_given_member_strategy_and_CMBC_strategy() {
        MemberStrategy memberStrategy = new MemberStrategy();
        CMBCStrategy cmbcStrategy = new CMBCStrategy();
        cinema.support(cmbcStrategy).support(memberStrategy);


        Payment payment = cinema.askForPrice(3);

        assertThat(payment.toString(), is("Method: Credit Card\nTotal price: 75"));
    }

    @Test
    public void should_get_payment_with_40_dollar_using_coupon_of_two_tickets() {
        strategy = new CouponStrategy();
        cinema.support(strategy);

        Payment payment = cinema.askForPrice(2);

        assertThat(payment.toString(), is("Method: Coupon\nTotal price: 40"));
    }
}
