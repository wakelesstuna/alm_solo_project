package com.example.springdocker.service;


import com.example.springdocker.model.Car;
import com.example.springdocker.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {

    CarService carService;

    @Mock
    CarRepository mockRepository;

    @BeforeEach
    void setUp() {
        carService = new CarService(mockRepository);
    }

    @Test
    void getCars() {
        Car car = new Car();
        car.setId("1")
                .setModel("XC60")
                .setBrand("Volvo")
                .setModelYear(2020);

        when(mockRepository.findAll())
                .thenReturn(Arrays.asList(car));

        List<Car> actual = carService.getCars();

        assertEquals(car.getBrand(),actual.get(0).getBrand());
        assertNotEquals("Not right",actual.get(0).getBrand());

        verify(mockRepository, times(1)).findAll();
    }

    @Test
    void saveCar() {
        Car car = new Car();
        car.setId("1")
                .setModel("XC60")
                .setBrand("Volvo")
                .setModelYear(2020);

        when(mockRepository.save(car))
                .thenReturn(car);

        Car actual = carService.saveNewCar(car);

        assertEquals(actual,car);

        verify(mockRepository, times(1)).save(any());

    }

    @Test
    void getByBrand() {
        Car car = new Car();
        car.setId("1")
                .setModel("XC60")
                .setBrand("Volvo")
                .setModelYear(2020);

        when(mockRepository.findAllByBrand("Volvo"))
                .thenReturn(Arrays.asList(car));

        List<Car> actual = carService.getByBrand("Volvo");

        assertEquals(actual, Arrays.asList(car));

        verify(mockRepository, times(1)).findAllByBrand(anyString());
    }

}
