package web.service;

import web.model.Car;

import java.util.List;

public interface CarService {

    public List<Car> getCarsWithLimit(Integer count);

    public Car getCarById(int id);
}

