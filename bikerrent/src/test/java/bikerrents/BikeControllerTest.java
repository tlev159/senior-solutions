package bikerrents;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BikeControllerTest {

    @Mock
    BikeService bikeService;

    @InjectMocks
    BikeController bikeController;

    @Test
    void testEmptyList() {
        List<BikeRent> tmp = Collections.emptyList();

        when((bikeService.getBikeRent())).thenReturn(tmp);

        List<BikeRent> result = bikeService.getBikeRent();

        assertThat(result)
                .hasSize(0)
                .isEmpty();
    }

    @Test
    void getHistory() {
        List<BikeRent> rentals = new ArrayList<>(List.of(
                new BikeRent("AG54", "HU345", LocalDateTime.of(2021, 6, 13, 10,0), 0.9),
                new BikeRent("AS92", "DE574", LocalDateTime.of(2021, 6, 14, 11,21), 12.9),
                new BikeRent("FG81", "IT234", LocalDateTime.of(2021, 6, 15, 12,41), 10.0),
                new BikeRent("SR85", "CH993", LocalDateTime.of(2021, 6, 16, 8,11), 65.4)
        ));

        when(bikeService.getBikeRents()).thenReturn(rentals);

        List<BikeRent> result = bikeService.getBikeRents();

        assertThat(result)
                .hasSize(4)
                .extracting(BikeRent::getBikeId)
                .contains("AG54", "SR85");

        verify(bikeService).getBikeRents();
    }

    @Test
    void getUserList() {

        when(bikeService.getUserList()).thenReturn(List.of("HU345", "DE574", "IT234", "CH993"));

        List<String> result = bikeService.getUserList();

        assertThat(result)
                .hasSize(4)
                .contains("DE574", "CH993");

        verify(bikeService).getUserList();
    }
}