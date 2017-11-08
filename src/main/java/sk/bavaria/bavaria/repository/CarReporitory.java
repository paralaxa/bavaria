package sk.bavaria.bavaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.bavaria.bavaria.model.Car;

public interface CarReporitory extends JpaRepository<Car,Long> {
}
