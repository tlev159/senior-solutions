package bikerrents;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BikeServiceTest {

    BikeService bikeService;

    @BeforeEach
    void setUp() {
        bikeService = new BikeService();
    }

    @Test
    void testEmptyListAtStart() {
        List<BikeRent> result = bikeService.getBikeRent();
        assertThat(result)
                .isEmpty();
    }

    @Test
    void getBikeRents() {
        List<BikeRent> result = bikeService.getBikeRents();

        assertThat(result)
                .hasSize(5)
                .extracting(BikeRent::getBikeId)
                .contains("FH636", "FH675");
    }

    @Test
    void getUserList() {
        List<BikeRent> bikeRentList = bikeService.getBikeRents();

        List<String> result = bikeService.getUserList();

        assertThat(result)
                .hasSize(5)
                .contains("US3334", "US346");
    }
}