package locations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LocationsControllerTest {

    @Mock
    LocationsService locationsService;

    @InjectMocks
    LocationsController locationsController;

    @Test
    void getLocations() {

//        when(locationsService.listLocations()).thenReturn(List.of(new Location(2L, "Valahol", 42.625, 24.18)));
//
//        String message = locationsController.listLocations().get(0).toString();
//
//        assertThat(message).isEqualTo("<p>2. Valahol (lat: 42.625, lon: 24.18)<p>");
    }
}