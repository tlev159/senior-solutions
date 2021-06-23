package car2spring;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static car2spring.State.*;

@Service
public class CarService {

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

    public List<Car> getAllCars() {
        return cars;
    }

    public List<String> getBrands() {
        return cars.stream()
                .map(Car::getBrand)
                .distinct()
                .collect(Collectors.toList());
    }
}
