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

    @GetMapping("/s")
    public List<LocationDto> getLocations(@RequestParam Optional<String> prefix) {
        return locationsService.getLocations(prefix);
    }

    @GetMapping
    public LocationDto findMinLonLatLocation(@RequestParam Optional<String> min) {
        return locationsService.findMinLonLocation(min);
    }

    @GetMapping("/{id}")
    public LocationDto findLocationById(@PathVariable("id") long id) {
        return locationsService.findLocationById(id);
    }


}
