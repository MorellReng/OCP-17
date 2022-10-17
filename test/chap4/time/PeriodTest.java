package chap4.time;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.UnsupportedTemporalTypeException;

public class PeriodTest {
    @Test
    void toStringYear() {
        Period ofYears = Period.ofYears(1);
        Assertions.assertEquals("P1Y", ofYears.toString());
    }

    @Test
    void toStringYearMonthDay() {
        Period period = Period.of(1, 2, 3);
        Assertions.assertEquals("P1Y2M3D", period.toString());
    }

    @Test
    void plus20Days() {
        Period period = Period.ofDays(20);
        LocalDate localDate = LocalDate.of(2022, 10, 1);

        LocalDate expected = LocalDate.of(2022, 10, 21);
        Assertions.assertEquals(expected, localDate.plus(period));
    }

    @Test
    void plusMonth() {
        Period period = Period.ofMonths(1);
        LocalDate localDate = LocalDate.of(2022, 10, 1);

        LocalDate expected = LocalDate.of(2022, 11, 1);
        Assertions.assertEquals(expected, localDate.plus(period));
    }

    @Test
    void unsupportedTypePlusThrowsUnsupportedTemporalTypeException() {
        Period period = Period.ofDays(1);
        LocalTime localTime = LocalTime.now();

        Assertions.assertThrows(UnsupportedTemporalTypeException.class, () -> localTime.plus(period));
    }
}
