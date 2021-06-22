package cars;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CarControllerTest {

    @Mock
    CarService carService;

    @InjectMocks
    CarController carController;

    @Test
    void getCarList() {

        List<Car> cars = new ArrayList<>(List.of(
                new Car("Opel", "Zafira", 5, StateOfCar.NORMAL,
                        List.of(new KmState(LocalDate.of(2017, 1, 12), 13),
                                new KmState(LocalDate.of(2018, 1, 10), 13_250),
                                new KmState(LocalDate.of(2019, 1, 11), 25_300))),
                new Car("Tesla", "Model3", 3, StateOfCar.PERFECT,
                        List.of(new KmState(LocalDate.of(2019, 5, 28), 5),
                                new KmState(LocalDate.of(2020, 6, 2), 19_650),
                                new KmState(LocalDate.of(2021, 6, 5), 32_580))),
                new Car("Volkswagen", "Golf VII", 5, StateOfCar.NORMAL,
                        List.of(new KmState(LocalDate.of(2017, 4, 17), 140),
                                new KmState(LocalDate.of(2019, 5, 15), 18_450),
                                new KmState(LocalDate.of(2021, 4, 20), 22_580))),
                new Car("Suzuki", "Swift", 25, StateOfCar.WRONG,
                        List.of(new KmState(LocalDate.of(2019, 8, 23), 251_520),
                                new KmState(LocalDate.of(2020, 9, 18), 274_800),
                                new KmState(LocalDate.of(2021, 5, 6), 293_540)))
        ));


        when(carService.getCars()).thenReturn(cars);

        List<Car> result = carService.getCars();

        assertThat(result)
                .hasSize(4)
                .extracting(Car::getProducerName)
                .contains("Opel", "Tesla");

        verify(carService, times(1)).getCars();
    }

    @Test
    void getBrands() {

        when(carService.getBrands()).thenReturn(List.of("Opel", "Tesla", "Volkswagen", "Suzuki"));

        List<String> result = carService.getBrands();

        assertThat(result)
                .hasSize(4)
                .contains("Tesla");

        verify(carService, times(1)).getBrands();
    }

}
