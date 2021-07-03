package locations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class LocationsIT {

    @Autowired
    LocationsController locationsController;

    @Test
    void getLocations() {
        List<LocationDto> temp = locationsController.getLocations(Optional.empty(), Optional.of(12.0), Optional.of(90.0), Optional.empty(), Optional.empty());
        assertThat(temp)
                .hasSize(4)
                .extracting(LocationDto::getName)
                .contains("Valahol");
    }

}
