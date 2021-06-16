package locations;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LocationOperationRepeatedTest {

    Object[][] values = {
            {new Location("Budapest", 45.1234, 43.55425), false},
            {new Location("SomeWhereOnEquator", 0, 13.55425), true},
            {new Location("Sydney", -45.1234, 43.55425), false},
            {new Location("AnotherLocationOnEquator", 0, 0), true}
    };


    @RepeatedTest(value = 4)
    void RepeatedTestIsOnEquator(RepetitionInfo repetitionInfo) {
        assertEquals(values[repetitionInfo.getCurrentRepetition() - 1][1],
                new LocationParser().isOnEquator((Location) values[repetitionInfo.getCurrentRepetition() - 1][0]));
    }

    static Stream<Arguments> locationStream() {
        return Stream.of(
                arguments(new Location("Budapest", 45.1234, 43.55425), false),
                arguments(new Location("SomeWhereOnEquator", 0, 13.55425), true),
                arguments(new Location("Sydney", -45.1234, 43.55425), false),
                arguments(new Location("London", 47.1234, 0), false)
        );
    }

    @ParameterizedTest
    @MethodSource("locationStream")
    void testIsLocationsOnEquator(Location actual, boolean result) {
        assertEquals(result, new LocationParser().isOnEquator(actual));
    }

}
