/*package com.example.springdocker.repository;

import com.example.springdocker.model.Food;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataMongoTest
public class FoodRepositoryTest {

    @Autowired
    private FoodRepository foodRepository;

    @Test
    void findFoodByCanICookIt() {
        Food mockFood = new Food();
        mockFood.setId("1")
        .setName("Pizza")
        .setDelicious(true)
        .setCamvnnICookIt(true);

        foodRepository.save(mockFood);

        List<Food> foodByCanICookIt = foodRepository.findFoodByCanICookIt(true);
        System.out.println(foodByCanICookIt.get(0).getName());

        assertEquals(mockFood.getName(),foodByCanICookIt.get(0).getName());
    }

}*/
