package locations;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationsController {

    private LocationsService locationsService;

    public LocationsController(LocationsService locationsService) {

        this.locationsService = locationsService;
    }

    @GetMapping
    public List<LocationDto> listLocations() {
        return locationsService.listLocations();
    }
//    @GetMapping
//    public String getLocations() {
//        StringBuilder result = new StringBuilder();
//        List<Location> temp = locationsService.getLocations();
//        for (Location location:temp) {
//            result.append("<p>").append(location.getId())
//                    .append(". ")
//                    .append(location.getName())
//                    .append(" (lat: ")
//                    .append(location.getLat())
//                    .append(", lon: ")
//                    .append(location.getLon())
//                    .append(")<p>");
//        }
//        return result.toString();
//    }

}
