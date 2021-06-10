package locations;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest implements PrintNameCapable {

    LocationParser locationParser;
    String location1 = "Bp,11.0,15.2254";
    String location2 = "NY,40.145,0.0";
    String location3 = "Eq,0.0,0.0";
    String location4 = "Somewhere,1.111,2.2254";


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
        assertEquals(false, locationParser.isOnEquator(location1));
        assertEquals(false, locationParser.isOnEquator(location4));
    }

    @Test
    void testIsOnEquatorTrue() {
        assertEquals(true, locationParser.isOnEquator(location3));
    }

    @Test
    void testIsOnPrimeMeridian() {
        assertEquals(true, locationParser.isOnPrime(location2));
        assertEquals(true, locationParser.isOnPrime(location3));
    }

    @Test
    void testIsNotOnPrimeMeridian() {
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
}