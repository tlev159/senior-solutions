package locations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocationNestedTest {

//    @BeforeEach
//    void init() {

    LocationParser locationParser = new LocationParser();
    Location location;
//    }

    @Nested
    class testWithFirstLocation {

        @BeforeEach
        void initFirst() {
            String locationText = "Szeged,0,0";
            location = locationParser.parse(locationText);

        }

        @Test
        void testIsLocation1OnEquator() {
            assertEquals(true, locationParser.isOnEquator(location));
        }

        @Test
        void testIsLocation1OnPrimeMeridian() {
            assertEquals(true, locationParser.isOnPrimeMeridian(location));
        }
    }

    @Nested
    class testWithSecondLocation {

        @BeforeEach
        void initSecond() {
            String locationText = "Szeged,47.497912,19.040235";
            location = locationParser.parse(locationText);
        }

        @Test
        void testIsLocation2OnEquator() {
            assertEquals(false, locationParser.isOnEquator(location));
        }

        @Test
        void testIsLocation2OnPrimeMeridian() {
            assertEquals(false, locationParser.isOnPrimeMeridian(location));
        }

    }
}
