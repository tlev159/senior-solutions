package locations;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class LocationsIT {

    @Autowired
    LocationsController locationsController;

    @Test
    void getLocations() {
        List<String> temp = locationsController.getLocations();
        assertThat(temp)
                .hasSize(4)
                .contains("Location{id=1, name='Valahol', lat=23.45, lon=34.45}");
    }

}
