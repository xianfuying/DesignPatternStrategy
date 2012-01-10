package com.movie;

import static com.movie.WeekDay.TUESDAY;

public class StrategyFactory {

    private static final String CMBC = "cmbc";

    public static Strategy getStrategy(WeekDay weekDay, String card, boolean member) {
        if (card.equals(CMBC))
            return new CMBCStrategy();

        if (weekDay == TUESDAY) {
            return new TuesdayStrategy();
        }

        if (member) {
            return new MemberStrategy();
        }
        return new BasicStrategy();
    }
}
