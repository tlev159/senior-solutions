package locations;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LocationServiceWithAssertJTest {

    Path file = Path.of("src/main/resources/locations.csv");

    LocationServices locationServices = new LocationServices();

    List<Location> temp;

    @BeforeEach
    void init() {

        temp = new ArrayList<>();
        temp.add(new Location("SomewhereThere", -50.334, 11.121));
        temp.add(new Location("SomewhereHere", 13.334, 13.1313));
        temp.add(new Location("SomewhereAnywhere", 16.334, 66.984));
        temp.add(new Location("SomewhereOverThere", -45.334, -42.556));
        temp.add(new Location("SomewhereAtTheSouthPol", -89.147, -2.121));
        temp.add(new Location("AtGreenwich", 51.477928, 0.0));
        temp.add(new Location("SomewhereInAfrica", -44.334, -11.121));
        temp.add(new Location("SomewhereAtTheEquator", 0, 0));
    }

    @Test
    void testWithAssertJ() {

        List<Location> locations = locationServices.readLocationsFromCsv(file);

        assertThat(locations)
                .hasSize(8)
                .extracting(Location::getName)
                .contains("AtGreenwich");
    }

    @Test
    void testWithTuple() {

        List<Location> locations = locationServices.readLocationsFromCsv(file);

        assertThat(locations)
                .extracting(Location::getName, Location::getLat)
                .contains(tuple("SomewhereAtTheEquator", 0.0));

    }

    @Test
    void testAssertJWithCondition() {

        List<Location> locations = locationServices.readLocationsFromCsv(file);

        Location location = locations.get(5);

        Condition<Location> isThereOnNullLatOrNullLon =
                new Condition<>(l -> l.getLat() == 0 || l.getLon() == 0, "Nor Lat or Lon is 0");

        assertThat(location).has(isThereOnNullLatOrNullLon);


    }

}
