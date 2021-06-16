package locations;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class LocationsController {


    @GetMapping("/locations")
    public String getLocations() {
        StringBuilder result = new StringBuilder();
        LocationsService locationsService = new LocationsService();
        List<Location> temp = locationsService.getLocations();
        for (Location location:temp) {
//        Location location = temp.get(0);
            result.append("<h3>").append(String.valueOf(location.getId()))
                    .append(". ")
                    .append(location.getName())
                    .append(" ( lat: ")
                    .append(String.valueOf(location.getLat()))
                    .append(", lon: ")
                    .append(String.valueOf(location.getLon()))
                    .append(")</h3>");
        }
        System.out.println(result);
        return result.toString();
//        return result;
    }

}
