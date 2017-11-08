package sk.bavaria.bavaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.bavaria.bavaria.model.Car;
import sk.bavaria.bavaria.repository.CarReporitory;

import java.util.List;

@RestController
@RequestMapping("car")
public class CarController {

    @Autowired
    private CarReporitory carReporitory;

    @PostMapping
    public Car create(@RequestBody(required = true) String brand) {
        Car car = new Car();
        car.setBrand(brand);
        return carReporitory.save(car);
    }

    @GetMapping
    public List<Car> getAll() {
        return carReporitory.findAll();
    }

}
