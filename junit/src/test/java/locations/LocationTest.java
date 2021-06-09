package locations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest implements PrintNameCapable {

    LocationParser locationParser;
    String location1 = "Bp,11.0,15.2254";
    String location2 = "NY,40.145,0.0";
    String location3 = "Eq,0.0,0.0";
    String location4 = "Somewhere,1.111,2.2254";


    @BeforeEach
    void doThisBefore() {
       locationParser = new LocationParser();
    }

    @Test
    void testParse() {

        String text = "Bp,47.497912,19.040235";

        assertEquals("Bp", locationParser.parse(text).getName());
        assertEquals(47.497912, locationParser.parse(text).getLat());
        assertEquals(19.040235, locationParser.parse(text).getLon());
    }

    @Test
    void testIsNotOnEquator() {
        assertFalse(locationParser.isOnEquator(location1));
        assertFalse(locationParser.isOnEquator(location4));
    }

    @Test
    void testIsOnEquatorTrue() {
        assertTrue(locationParser.isOnEquator(location3));
    }

    @Test
    void testIsOnPrimeMeridian() {
        assertTrue(locationParser.isOnPrime(location2));
        assertTrue(locationParser.isOnPrime(location3));
    }

    @Test
    void testIsNotOnPrimeMeridian() {
        assertFalse(locationParser.isOnPrime(location1));
        assertFalse(locationParser.isOnPrime(location4));
    }

}