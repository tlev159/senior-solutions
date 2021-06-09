package locations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {

    @Test
    void testParse() {

        String text = "Bp,47.497912,19.040235";

        assertEquals("Bp", new LocationParser().parse(text).getName());
        assertEquals(47.497912, new LocationParser().parse(text).getLat());
        assertEquals(19.040235, new LocationParser().parse(text).getLon());
    }
}