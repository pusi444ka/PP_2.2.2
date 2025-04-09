package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private List<Car> cars = List.of(
            new Car(1, "BMW", 5),
            new Car(2, "Audi", 3),
            new Car(3, "Mercedes", 7),
            new Car(4, "Toyota", 6),
            new Car(5, "Honda", 8));

    @Override
    public List<Car> getCars(int count) {
        if (count >= 5) {
            return cars;
        }
        return cars.stream()
                .limit(count)
                .toList();
    }

    @Override
    public List<Car> getAllCars() {
        return cars;
    }
}
