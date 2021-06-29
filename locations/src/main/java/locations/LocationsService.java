package locations;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class LocationsService {

    private ModelMapper modelMapper;

    private List<Location> locations = new ArrayList<>(List.of(
     new Location(1L, "Valahol", 23.45, 34.45),
     new Location(2L, "Amott", 34.56, 12.23),
     new Location(3L, "Emitt", 56.45, 53.45),
     new Location(4L, "Sehol", 0.0, 0.0)
    ));

    public LocationsService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public List<LocationDto> getLocations() {
        Type targetListType = new TypeToken<List<LocationDto>>(){}.getType();
        return modelMapper.map(locations, targetListType);
    }
}
