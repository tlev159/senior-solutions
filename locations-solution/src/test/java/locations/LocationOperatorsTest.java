package locations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class LocationOperatorsTest {

    List<Location> locations = new ArrayList<>();

    @BeforeEach
    void init() {
        locations.add(new Location("SomewhereThere",-50.334,11.121));
        locations.add(new Location("SomewhereHere",13.334,13.1313));
        locations.add(new Location("SomewhereAnywhere",16.334,66.984));
        locations.add(new Location("SomewhereOverThere",-45.334,-42.556));
        locations.add(new Location("SomewhereAtTheSouthPol",-89.147,-2.121));
        locations.add(new Location("AtGreenwich",51.477928,0.0));
        locations.add(new Location("SomewhereInAfrica",-44.334,-11.121));
        locations.add(new Location("SomewhereAtTheEquator",0.334,25.754));
    }

    @Test
    void filterOnNorth() {

        List<Location> expectedResult = locations.stream().filter(l -> l.getLat() > 0).collect(Collectors.toList());

        List<Location> actualResult = new LocationOperators().filterOnNorth(locations);

        assertEquals(4, actualResult.size());
        assertEquals(expectedResult.get(0).toString(), actualResult.get(0).toString());
    }

    @Test
    void testNameOfFilteredLocationsOnTheNorthHalfOfTheWorld() {

        List<Location> expectedResult = locations.stream().filter(l -> l.getLat() > 0).collect(Collectors.toList());

        List<Location> actualResult = new LocationOperators().filterOnNorth(locations);

        assertEquals("SomewhereAnywhere", actualResult.get(1).getName());
    }
}