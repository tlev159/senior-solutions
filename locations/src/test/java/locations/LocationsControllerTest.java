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

//    @Test
//    void getLocations() {
//
//        Location location = new Location(1L, "Bárhol", 14.14, 13.13);
//
//        when(locationsService.getLocations())
//                .thenReturn(List.of(new Location(1L, "Bárhol", 14.14, 13.13)));
//        assertThat(locationsController.getLocations())
//                .hasSize(1);
//    }
}