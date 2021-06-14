package locations;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest implements PrintNameCapable {

    LocationParser locationParser;
    String locationTxt1 = "Bp,11.0,15.2254";
    String locationTxt2 = "NY,40.145,0.0";
    String locationTxt3 = "Eq,0.0,0.0";
    String locationTxt4 = "Somewhere,1.111,2.2254";


    @BeforeEach
    @DisplayName("Do this before each test methods")
    void doThisBefore() {
       locationParser = new LocationParser();
    }

    @Test
    @DisplayName("Test parse method from LocationParser class")
    void testParse() {

        String text = "Bp,47.497912,19.040235";

        Location l = locationParser.parse(text);

        assertEquals("Bp", l.getName());
        assertEquals(47.497912, l.getLat());
        assertEquals(19.040235, l.getLon());
    }

    @Test
    @DisplayName("Test with locations not on Equator")
    void testIsNotOnEquator() {

        Location location1 = locationParser.parse(locationTxt1);
        Location location4 = locationParser.parse(locationTxt4);
        assertEquals(false, locationParser.isOnEquator(location1));
        assertEquals(false, locationParser.isOnEquator(location4));
    }

    @Test
    void testIsOnEquatorTrue() {

        Location location3 = locationParser.parse(locationTxt3);

        assertEquals(true, locationParser.isOnEquator(location3));
    }

    @Test
    void testIsOnPrimeMeridian() {

        Location location2 = locationParser.parse(locationTxt2);
        Location location3 = locationParser.parse(locationTxt3);

        assertEquals(true, locationParser.isOnPrime(location2));
        assertEquals(true, locationParser.isOnPrime(location3));
    }

    @Test
    void testIsNotOnPrimeMeridian() {

        Location location1 = locationParser.parse(locationTxt1);
        Location location4 = locationParser.parse(locationTxt4);

        assertEquals(false, locationParser.isOnPrime(location1));
        assertEquals(false, locationParser.isOnPrime(location4));
    }

    @Test
    void testParseTwice() {

        String text = "Bp,47.497912,19.040235";

        Location l1 = locationParser.parse(text);
        Location l2 = locationParser.parse(text);

        assertEquals(l1.getName(), l2.getName());
        assertEquals(l1.getLat(), l2.getLat());
        assertEquals(l1.getLon(), l2.getLon());

        assertSame(false, l1 == l2);
    }

    @Test
    void testDistance() {

        String locationOfSzegedZoo = "Szeged,46.25190915461344, 20.118282168918878";
        String locationOfBudapestZoo = "Budapest,47.519099118506574, 19.077632568969534";

        Location l1 = locationParser.parse(locationOfSzegedZoo);
        Location l2 = locationParser.parse(locationOfBudapestZoo);

        double distance = 161.55;

        assertEquals(distance, l1.distance(l2), 0.08);
    }

    @Test
    void testAllParameterOfLocationParser() {

        String locationOfSzegedZoo = "Szeged,46.25190915461344,20.118282168918878";

        Location resultLocation = locationParser.parse(locationOfSzegedZoo);
        String result = resultLocation.getName() + "," + resultLocation.getLat() + "," + resultLocation.getLon();

        assertEquals(locationOfSzegedZoo, result);
    }

    @Test
    void testWrongLatitudeParameterLower() {

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new Location("SomewhereThere",-90.334,11.121));
        assertEquals("Latitude parameter is not correct!", ex.getMessage());
    }

    @Test
    void testWrongLatitudeParameterHigher() {

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new Location("SomewhereThere",94.334,11.121));
        assertEquals("Latitude parameter is not correct!", ex.getMessage());
    }

    @Test
    void testWrongLongitudeParameterLower() {

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new Location("SomewhereThere",-9.334,-195.121));
        assertEquals("Longitude parameter is not correct!", ex.getMessage());
    }

    @Test
    void testWrongLongitudeParameterHigher() {

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new Location("SomewhereThere",-9.334,211.121));
        assertEquals("Longitude parameter is not correct!", ex.getMessage());
    }

}