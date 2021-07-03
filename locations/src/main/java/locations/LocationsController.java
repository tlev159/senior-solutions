package locations;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/locations")
public class LocationsController {

    LocationsService locationsService;

    public LocationsController(LocationsService locationsService) {
        this.locationsService = locationsService;
    }

    @GetMapping()
    public List<LocationDto> getLocations(@RequestParam Optional<String> prefix, @RequestParam Optional<Double> minLat, @RequestParam Optional<Double> maxLat, @RequestParam Optional<Double> minLon, @RequestParam Optional<Double> maxLon) {
        return locationsService.getLocations(prefix, minLat, maxLat, minLon, maxLon);
    }


    @GetMapping("/{id}")
    public LocationDto findLocationById(@PathVariable("id") long id) {
        return locationsService.findLocationById(id);
    }


}
