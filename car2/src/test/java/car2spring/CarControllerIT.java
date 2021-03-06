package car2spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CarControllerIT {

    @Autowired
    CarController carController;

    @Test
    void getCarList() {
        List<Car> result = carController.getAllCars();

        assertThat(result)
                .hasSize(4)
                .extracting(Car::getBrand)
                .contains("Opel", "Tesla");
    }

    @Test
    void getBrands() {
        List<String> result = carController.getBrands();

        assertThat(result)
                .hasSize(4)
                .contains("Tesla", "Volvo");
    }

}
