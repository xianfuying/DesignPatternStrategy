package com.movie;

import org.junit.Test;

import static com.movie.WeekDay.MONDAY;
import static com.movie.WeekDay.TUESDAY;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;

public class StrategyFactoryTest {
    private static final String WITHOUT_CARD = "no";
    private static final String CMBC = "cmbc";

    @Test
    public void should_get_basic_strategy_at_monday_without_CMBC() {
        Strategy strategy = StrategyFactory.getStrategy(MONDAY, WITHOUT_CARD, false);

        assertThat(strategy, instanceOf(BasicStrategy.class));
    }

    @Test
    public void should_get_tuesday_strategy_at_tuesday_without_CMBC() {
        Strategy strategy = StrategyFactory.getStrategy(TUESDAY, WITHOUT_CARD, false);

        assertThat(strategy, instanceOf(TuesdayStrategy.class));
    }

    @Test
    public void should_get_CMBC_strategy_when_using_CMBC() {
        Strategy strategy = StrategyFactory.getStrategy(TUESDAY, CMBC, false);

        assertThat(strategy, instanceOf(CMBCStrategy.class));
    }

    @Test
    public void should_get_Member_strategy() {
        Strategy strategy = StrategyFactory.getStrategy(WeekDay.MONDAY, WITHOUT_CARD, true);

        assertThat(strategy, instanceOf(MemberStrategy.class));
    }
}