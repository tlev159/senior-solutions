package locations;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class LocationsService {

    private AtomicLong id = new AtomicLong();

    private ModelMapper modelMapper;

    public LocationsService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    private List<Location> locations = new ArrayList<>(List.of(
     new Location(id.incrementAndGet(), "Somewhere", 23.45, 34.45),
     new Location(id.incrementAndGet(), "There", 34.56, -12.23),
     new Location(id.incrementAndGet(), "Here", -56.45, 53.45),
     new Location(id.incrementAndGet(), "Nowhere", 10.0, 50.0)
    ));

    public List<LocationDto> getLocations(Optional<String> prefix, Optional<Double> minLat, Optional<Double> maxLat, Optional<Double> minLon, Optional<Double> maxLon) {
        Type targetListType = new TypeToken<List<LocationDto>>(){}.getType();
        return modelMapper.map(locations.stream()
                .filter(l -> prefix.isEmpty() || l.getName().equalsIgnoreCase(prefix.get()))
                .filter(l-> minLat.isEmpty() || l.getLat() >= minLat.get())
                .filter(l-> maxLat.isEmpty() || l.getLat() <= maxLat.get())
                .filter(l-> minLon.isEmpty() || l.getLon() >= minLon.get())
                .filter(l-> maxLon.isEmpty() || l.getLon() <= maxLon.get())
                .collect(Collectors.toList()), targetListType);
    }

    public LocationDto findLocationById(long id) {
        return  modelMapper.map(findById(id), LocationDto.class);
    }

    private Location findById(long id) {
        Location result = locations.stream()
                .filter(l-> l.getId() == id)
                .findFirst()
                .orElseThrow(()-> new LocationNotFoundException("Location not found! (id: " + id + ")"));
        return result;
    }

    public LocationDto createLocation(CreateLocationCommand command) {
        Location location = new Location(id.incrementAndGet(), command.getName(), command.getLat(), command.getLon());
        locations.add(location);
        return modelMapper.map(location, LocationDto.class);
    }

    public LocationDto updateLocation(long id, UpdateLocationCommand command) {
        Location result = findById(id);
        result.setName(command.getName());
        result.setLat(command.getLat());
        result.setLon(command.getLon());
        return modelMapper.map(result, LocationDto.class);
    }

    public void deleteById(long id) {
        locations.remove(findById(id));
    }
}
