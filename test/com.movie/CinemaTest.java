package com.movie;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CinemaTest {
    private Cinema cinema;
    private Strategy strategy;

    @Test
    public void should_get_one_ticket_when_given_50_dollar() {
        strategy = new BasicStrategy();
        cinema = new Cinema(strategy);

        List<MovieTicket> movieTickets = cinema.buy(50);

        assertThat(movieTickets.size(), is(1));
    }

    @Test
    public void should_get_two_tickets_when_given_100_dollar() {
        strategy = new BasicStrategy();
        cinema = new Cinema(strategy);

        List<MovieTicket> movieTickets = cinema.buy(100);

        assertThat(movieTickets.size(), is(2));
    }

    @Test
    public void should_get_one_ticket_when_given_25_dollar() {
        strategy = new TuesdayStrategy();
        cinema = new Cinema(strategy);

        List<MovieTicket> movieTickets = cinema.buy(25);

        assertThat(movieTickets.size(), is(1));
    }

    @Test
    public void should_get_two_tickets_when_given_50_dollar() {
        strategy = new TuesdayStrategy();
        cinema = new Cinema(strategy);

        List<MovieTicket> movieTickets = cinema.buy(50);

        assertThat(movieTickets.size(), is(2));
    }

    @Test
    public void should_get_two_tickets_when_given_50_dollar_using_CMBC() {
        strategy = new CMBCStrategy();
        cinema = new Cinema(strategy);

        List<MovieTicket> movieTickets = cinema.buy(50);

        assertThat(movieTickets.size(), is(2));
    }

    @Test
    public void should_get_three_tickets_when_given_100_dollar_as_member() {
        strategy = new MemberStrategy();
        cinema = new Cinema(strategy);

        List<MovieTicket> movieTickets = cinema.buy(100);

        assertThat(movieTickets.size(), is(3));
    }

    @Test
    public void should_get_four_tickets_when_given_150_dollar_as_member() {
        strategy = new MemberStrategy();
        cinema = new Cinema(strategy);

        List<MovieTicket> movieTickets = cinema.buy(150);

        assertThat(movieTickets.size(), is(4));
    }
}
