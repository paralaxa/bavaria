package sk.bavaria.bavaria.service;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sk.bavaria.bavaria.model.Car;
import sk.bavaria.bavaria.model.CarPhoto;
import sk.bavaria.bavaria.repository.CarReporitory;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("car")
@Api(value = "car", description = "Basic crud over car entity.")
public class CarService {

    @Autowired
    private CarReporitory carReporitory;

    @PostMapping
    public Long create(@RequestParam(required = true) String brand, @RequestParam MultipartFile photo) throws Exception {
        Car car = new Car();
        car.setBrand(brand);
        if (photo != null) {
            CarPhoto carPhoto = new CarPhoto();
            carPhoto.setData(photo.getBytes());
            car.setPhotos(Arrays.asList(carPhoto));
        }
        return carReporitory.save(car).getId();
    }

    @GetMapping
    public List<Car> getAll() {
        return carReporitory.findAll();
    }

    @GetMapping(path = "/photos/{id}")
    public List<CarPhoto> photos(@PathVariable(required = true) Long id) {
        return carReporitory.findOne(id).getPhotos();
    }

}
