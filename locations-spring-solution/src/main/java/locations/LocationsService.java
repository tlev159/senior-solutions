package locations;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class LocationsService {

    private ModelMapper modelMapper;

    private List<Location> locations = Collections.synchronizedList(new ArrayList<>(List.of(
            new Location(1L, "Budapest", 45.4, 43.3),
            new Location(2L, "Berlin", 37.4, 35.3),
            new Location(3L, "Bonn", 33.4, 43.4),
            new Location(4L, "Szeged", 46.4, 43.7),
            new Location(5L, "Nürnberg", 40.4, 46.3),
            new Location(6L, "Stutgart", 39.4, 40.3),
            new Location(7L, "Győr", 44.4, 33.3),
            new Location(8L, "Siófok", 44.9, 23.3)
    )));

    public LocationsService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    //    public List<Location> getLocations() {
//        return new ArrayList<>(List.of(
//            new Location(1L, "Budapest", 45.4, 43.3),
//            new Location(2L, "Berlin", 37.4, 35.3),
//            new Location(3L, "Bonn", 33.4, 43.4),
//            new Location(4L, "Szeged", 46.4, 43.7),
//            new Location(5L, "Nürnberg", 40.4, 46.3),
//            new Location(6L, "Stutgart", 39.4, 40.3),
//            new Location(7L, "Győr", 44.4, 33.3),
//            new Location(8L, "Siófok", 44.9, 23.3)
//        ));
//    }

    public List<LocationDto> listLocations() {
        Type targetListType = new TypeToken<List<LocationDto>>(){}.getType();
        return modelMapper.map(locations, targetListType);
    }
}
