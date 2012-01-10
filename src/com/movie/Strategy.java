package com.movie;

import java.util.List;

public interface Strategy {
    List<MovieTicket> buy(double money);
}
