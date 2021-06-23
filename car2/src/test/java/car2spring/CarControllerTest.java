package car2spring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static car2spring.State.*;
import static car2spring.State.NORMAL;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CarControllerTest {

    @Mock
    CarService carService;

    @InjectMocks
    CarController carController;

    @Test
    void getAllCars() {

        List<Car> cars = new ArrayList<>(List.of(
                new Car("Opel", "Zafira", 12, BAD,
                        List.of(new KmState(LocalDate.of(2017, 2, 14), 180304),
                                new KmState(LocalDate.of(2019, 3, 16), 214034),
                                new KmState(LocalDate.of(2020, 4, 21), 245034))),
                new Car("Volkswagen", "Golf VII", 7, NORMAL,
                        List.of(new KmState(LocalDate.of(2018, 5, 21), 180),
                                new KmState(LocalDate.of(2019, 8, 22), 14587),
                                new KmState(LocalDate.of(2021, 2, 23), 35420))),
                new Car("Tesla", "Model3", 3, GOOD,
                        List.of(new KmState(LocalDate.of(2019, 1, 26), 18),
                                new KmState(LocalDate.of(2020, 4, 27), 15400),
                                new KmState(LocalDate.of(2021, 6, 28), 29510))),
                new Car("Volvo", "XC60", 7, NORMAL,
                        List.of(new KmState(LocalDate.of(2017, 2, 13), 18034),
                                new KmState(LocalDate.of(2019, 4, 17), 28034),
                                new KmState(LocalDate.of(2021, 7, 23), 38034)))

        ));


        when(carService.getAllCars()).thenReturn(cars);

        List<Car> result = carService.getAllCars();

        assertThat(result)
                .hasSize(4)
                .extracting(Car::getBrand, Car::getType)
                .contains(tuple("Opel", "Zafira"));
    }

    @Test
    void getBrands() {

        when(carService.getBrands()).thenReturn(List.of("Opel", "Volkswagen", "Tesla", "Volvo"));

        List<String> result = carService.getBrands();

        assertThat(result)
                .hasSize(4)
                .contains("Volvo", "Tesla");
    }
}