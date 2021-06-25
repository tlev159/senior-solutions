package bikerrents;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BikeControllerIT {

    @Autowired
    BikeController bikeController;

    @Test
    void getCarList() {
        List<BikeRent> result = bikeController.getHistory();

        assertThat(result)
                .hasSize(5)
                .extracting(BikeRent::getBikeId)
                .contains("FH636", "FH675");
    }

    @Test
    void getUserList() {

        List<String> result = bikeController.getUserList();

        assertThat(result)
                .hasSize(5)
                .contains("US3334", "US346");
    }
}
