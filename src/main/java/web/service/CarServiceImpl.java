package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.Car;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final List<Car> cars = List.of(
            new Car(1, "BMW", 5),
            new Car(2, "Audi", 3),
            new Car(3, "Mercedes", 7),
            new Car(4, "Toyota", 6),
            new Car(5, "Honda", 8)
    );

    @Override
    public List<Car> getCarsWithLimit(Integer count) {
        if (count == null || count >= cars.size()) {
            return cars;
        }
        return cars.stream()
                .limit(count)
                .toList();
    }

    @Override
    public Car getCarById(int id) {
        return cars.stream()
                .filter(car -> car.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Car not found with ID: " + id));
    }
}