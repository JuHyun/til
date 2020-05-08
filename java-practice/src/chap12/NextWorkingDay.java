package chap12;

import java.time.DayOfWeek;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class NextWorkingDay implements TemporalAdjuster {

    @Override
    public Temporal adjustInto(Temporal temporal) {
        DayOfWeek now = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
        if (now == DayOfWeek.FRIDAY) return temporal.plus(3, ChronoUnit.DAYS);
        else if (now == DayOfWeek.SATURDAY) return temporal.plus(2, ChronoUnit.DAYS);
        return temporal.plus(1, ChronoUnit.DAYS);
    }
}
