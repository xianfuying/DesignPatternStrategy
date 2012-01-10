package com.movie;

import java.util.ArrayList;
import java.util.List;

public class TicketCreator {
    public static List<MovieTicket> getTickets(double count) {
        List<MovieTicket> movieTickets = new ArrayList<MovieTicket>();
        for (int i = 0; i < count; i++) {
            movieTickets.add(new MovieTicket());
        }
        return movieTickets;
    }
}
