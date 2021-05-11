package com.example.springdocker.controller;

import com.example.springdocker.model.Food;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @GetMapping("/")
    public List<Food> getFoods() {
        return carService.getCars();
    }

    @PostMapping("/add")
    public void saveNewFood(@RequestBody Car car) {
        carService.saveNewCar(car);
    }

    @GetMapping("/get/by/brand")
    public List<String> getCarsByBrand(@RequestParam String brand) {
        return carService.getByBrand(brand);
    }

}
