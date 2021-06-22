package locations;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class LocationIT {

    @Autowired
    LocationsController locationsController;

    @Test
    void getLocation() {
        String message = locationsController.listLocations().get(0).toString();

        assertThat(message)
                .startsWith("<p>1. Budapest");
    }
}
