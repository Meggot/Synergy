package com.models;

import java.time.OffsetDateTime;

public enum DatePeriod {

    DAY,
    WEEK,
    MONTH,
    YEAR,
    ALL;

    public OffsetDateTime getDate() {

        switch (this) {
            case DAY:
                return OffsetDateTime.now().minusDays(1);
            case WEEK:
                return OffsetDateTime.now().minusWeeks(1);
            case MONTH:
                return OffsetDateTime.now().minusMonths(1);
            case YEAR:
                return OffsetDateTime.now().minusYears(1);
            case ALL:
            default:
                return OffsetDateTime.MIN;
        }
    }
}
