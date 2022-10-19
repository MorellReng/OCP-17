package chap4.time;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.UnsupportedTemporalTypeException;

public class DurationTest {

    @Test
    void toStringDaily() {
        Duration daily = Duration.ofDays(1);
        Duration daily2 = Duration.of(1, ChronoUnit.DAYS);

        String expected = "PT24H";

        Assertions.assertEquals(expected, daily.toString());
        Assertions.assertEquals(expected, daily2.toString());
    }

    @Test
    void durationOfChronUnitTwoYears() {
        // throws exception
        // Duration twoYears = Duration.of(2, ChronoUnit.YEARS);
        Assertions.assertThrows(UnsupportedTemporalTypeException.class, () -> Duration.of(2, ChronoUnit.YEARS));


        // 24 * 365 * 2
        String expected = "PT17520H";

        // Assertions.assertEquals(expected, twoYears.toString());
    }
}
