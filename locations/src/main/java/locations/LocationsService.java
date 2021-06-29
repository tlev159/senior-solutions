package locations;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class LocationsService {

    private ModelMapper modelMapper;

    private List<Location> locations = new ArrayList<>(List.of(
     new Location(1L, "Somewhere", 23.45, 34.45),
     new Location(2L, "There", 34.56, -12.23),
     new Location(3L, "Here", -56.45, 53.45),
     new Location(4L, "Nowhere", 10.0, 50.0)
    ));

    public LocationsService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public List<LocationDto> getLocations(Optional<String> prefix) {
        Type targetListType = new TypeToken<List<LocationDto>>(){}.getType();
            List<Location> filtered = locations.stream()
                .filter(l -> prefix.isEmpty() || l.getName().toLowerCase().equals(prefix.get().toLowerCase()))
                .collect(Collectors.toList());
        return modelMapper.map(filtered, targetListType);
    }

    public LocationDto findLocationById(long id) {
        return  modelMapper.map(locations.stream()
                .filter(l-> l.getId() == id)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Can not found: " + id)), LocationDto.class);
    }

    public LocationDto findMinLonLocation(Optional<String> min) {
        Type targetListType = new TypeToken<LocationDto>(){}.getType();
        if (min.get().equalsIgnoreCase("lat")) {
            return modelMapper.map(locations.stream()
                    .min(Comparator.comparing(Location::getLat)).get(), targetListType);
        } else {
            return modelMapper.map(locations.stream()
                    .min(Comparator.comparing(Location::getLon)).get(), targetListType);
        }
    }
}
