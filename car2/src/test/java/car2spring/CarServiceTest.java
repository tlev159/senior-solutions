package car2spring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

class CarServiceTest {

    CarService carService;

    @BeforeEach
    void setUp() {
        carService = new CarService();
    }

    @Test
    void getAllCars() {
        List<Car> result = carService.getAllCars();

        assertThat(result)
                .hasSize(4)
                .extracting(Car::getBrand, Car::getType)
                .contains(tuple("Tesla", "Model3"));
    }

    @Test
    void getBrands() {
        List<String> result = carService.getBrands();

        assertThat(result)
                .hasSize(4)
                .contains("Volkswagen", "Opel");

    }
}