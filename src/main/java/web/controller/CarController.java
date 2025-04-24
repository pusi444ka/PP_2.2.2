package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.Car;
import web.service.CarService;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String showCars(@RequestParam(required = false) Integer count, Model model) {
        List<Car> cars = carService.getCarsWithLimit(count);
        model.addAttribute("cars", cars);
        return "cars";
    }

    @GetMapping("/{id}")
    public String getCar(@PathVariable int id, Model model) {
        Car car = carService.getCarById(id);
        model.addAttribute("car", car);
        return "car-details";
    }
}
