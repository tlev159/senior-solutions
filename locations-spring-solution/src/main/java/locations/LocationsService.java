package locations;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationsService {

//    private List<Location> locations = new ArrayList<>();
//
//    public LocationsService() {
//        locations.add(new Location(1L, "Budapest", 45.4, 43.3));
//        locations.add(new Location(2L, "Berlin", 37.4, 35.3));
//        locations.add(new Location(3L, "Bonn", 33.4, 43.4));
//        locations.add(new Location(4L, "Szeged", 46.4, 43.7));
//        locations.add(new Location(5L, "Nürnberg", 40.4, 46.3));
//        locations.add(new Location(6L, "Stutgart", 39.4, 40.3));
//        locations.add(new Location(7L, "Győr", 44.4, 33.3));
//        locations.add(new Location(8L, "Siófok", 44.9, 23.3));
//    }

    public List<Location> getLocations() {
        return new ArrayList<>(List.of(
            new Location(1L, "Budapest", 45.4, 43.3),
            new Location(2L, "Berlin", 37.4, 35.3),
            new Location(3L, "Bonn", 33.4, 43.4),
            new Location(4L, "Szeged", 46.4, 43.7),
            new Location(5L, "Nürnberg", 40.4, 46.3),
            new Location(6L, "Stutgart", 39.4, 40.3),
            new Location(7L, "Győr", 44.4, 33.3),
            new Location(8L, "Siófok", 44.9, 23.3)
        ));
    }
}
