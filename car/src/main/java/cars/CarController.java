package cars;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public List<Car> getCarList() {
        return carService.getCars();
    }

    @GetMapping("/types")
    public List<String> getBrands() {
        return carService.getBrands();
    }
}
