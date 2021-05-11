package com.example.springdocker.repository;

import com.example.springdocker.model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {

    Optional<List<Car>> findAllByBrand(String brand);

}
