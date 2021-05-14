package com.example.springdocker.service;

import com.example.springdocker.model.Car;
import com.example.springdocker.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public List<Car> getCars() {
        return carRepository.findAll();
    }

    public Car saveNewCar(Car car) {
        return carRepository.save(car);
    }

    public List<Car> getByBrand(String brand) {
        return carRepository.findAllByBrand(brand);
    }
}
