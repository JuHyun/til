package chap12;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import static java.time.temporal.TemporalAdjusters.nextOrSame;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.TimeZone;

public class LocalDateTimeExerciseTest {

    @Test
    public void test() {
        LocalDateTime dt1 = LocalDateTime.of(2020, 5, 1, 18, 0, 7);
        System.out.println(dt1.toLocalDate().toString());
        System.out.println(dt1.toLocalTime().toString());
    }

    @Test
    public void instantTest() {
        Instant instant = Instant.ofEpochSecond(9, 1_000_000_000);
        System.out.println(instant);
    }

    @Test
    public void durationTest() {
        LocalTime time1 = LocalTime.of(10, 10, 10);
        LocalTime time2 = LocalTime.of(20, 20, 20);
        Duration duration1 = Duration.between(time1, time2);
        System.out.println(" : " + duration1.toMinutes());

        Duration threeMinutes = Duration.ofMinutes(3);
        Period tenDays = Period.ofDays(10);
        System.out.println(tenDays);
    }

    @Test
    public void adjustDateTest() {
        LocalDate date1 = LocalDate.of(2020, 4, 26);
        LocalDate date2 = date1.withYear(2021);
        LocalDate date3 = date2.withDayOfMonth(5);
        LocalDate date4 = date3.with(ChronoField.MONTH_OF_YEAR, 9);
        System.out.println(date1.toString());
        System.out.println(date2.toString());
        System.out.println(date3.toString());
        System.out.println(date4.toString());
    }

    @Test
    public void temporalAdjuster() {
        LocalDate date = LocalDate.of(2020, 4, 26);
        LocalDate date1 = date.with(nextOrSame(DayOfWeek.MONDAY));
        LocalDate date2 = date1.with(lastDayOfMonth());
        System.out.println(date.toString());
        System.out.println(date1.toString());
        System.out.println(date2.toString());
    }

    @Test
    public void 퀴즈_12_2() {
        LocalDate date = LocalDate.of(2020, 4, 26);
        date = date.with(new NextWorkingDay());
        System.out.println(date);
    }

    @Test
    public void dateTimeFormatterTest() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd", Locale.GERMANY);
        LocalDate childrenDay = LocalDate.of(2020, 5, 5);
        String formattedDate = childrenDay.format(formatter);
        LocalDate date2 = LocalDate.parse(formattedDate, formatter);
        System.out.println(childrenDay);
        System.out.println(formattedDate);
        System.out.println(date2);
    }

    @Test
    public void zoneIdTest() {
        ZoneId parisZone = ZoneId.of("Europe/Paris");
        LocalDate date = LocalDate.of(2020, Month.APRIL, 27);
        ZonedDateTime zonedDateTime = date.atStartOfDay(parisZone);
        System.out.println(zonedDateTime.toLocalDateTime().toString());
    }

    @Test
    public void zoneOffSetTest() {
        LocalDateTime now = LocalDateTime.now(ZoneId.of("UTC"));
        System.out.println(now);
    }
}
