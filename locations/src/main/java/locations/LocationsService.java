package locations;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationsService {

    private List<Location> locations = new ArrayList<>(List.of(
     new Location(1L, "Valahol", 23.45, 34.45),
     new Location(2L, "Amott", 34.56, 12.23),
     new Location(3L, "Emitt", 56.45, 53.45),
     new Location(4L, "Sehol", 0.0, 0.0)
    ));


    public List<Location> getLocations() {
        return locations;
    }
}
