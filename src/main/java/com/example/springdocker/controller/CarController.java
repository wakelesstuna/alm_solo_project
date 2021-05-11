package com.example.springdocker.controller;

import com.example.springdocker.model.Car;
import com.example.springdocker.model.Food;
import com.example.springdocker.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @GetMapping("/")
    public List<Car> getFoods() {
        return carService.getCars();
    }

    @PostMapping("/add")
    public Car saveNewFood(@RequestBody Car car) {
        return carService.saveNewCar(car);
    }

    @GetMapping("/get/by/brand")
    public List<Car> getCarsByBrand(@RequestParam String brand) {
        return carService.getByBrand(brand);
    }

}
