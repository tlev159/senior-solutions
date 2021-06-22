package cars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarServiceTest {

    CarService carService;

    @BeforeEach
    void init() {
        carService = new CarService();
    }

    @Test
    void getCars() {
        List<Car> result = carService.getCars();

        assertThat(result)
                .hasSize(4)
                .extracting(Car::getProducerName)
                .contains("Opel", "Tesla");
    }

    @Test
    void getBrands() {
        List<String> result = carService.getBrands();

        assertThat(result)
                .hasSize(4)
                .contains("Tesla");
    }
}