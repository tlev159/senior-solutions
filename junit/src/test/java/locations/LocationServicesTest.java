package locations;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
//import static org.hamcrest.Matchers.assertThat;


class LocationServicesTest {

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
        temp.add(new Location("SomewhereAtTheEquator", 0.334, 25.754));
    }

    @Test
    void readLocationsFromCsv() {

        List<Location> result = temp.stream().filter(l -> l.getLon() == 0.0).collect(Collectors.toList());
        List<Location> locations = locationServices.readLocationsFromCsv(file);

        assertThat(locations.get(5).getName(), equalTo(result.get(0).getName()));
    }

    @Test
    void testReadLocationNames() {

        List<String> result = temp
                .stream()
                .map(Location::getName)
                .collect(Collectors.toList());

        List<String> locations = locationServices.readLocationsFromCsv(file)
                .stream()
                .map(Location::getName)
                .collect(Collectors.toList());

        assertThat(locations, equalTo(result));

        assertThat(locations, hasItem(result.get(4)));
    }
}