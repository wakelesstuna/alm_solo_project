package com.example.springdocker.service;

import com.example.springdocker.model.Food;
import com.example.springdocker.repository.FoodRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FoodServiceTest {

    FoodService foodService;

    @Mock
    FoodRepository mockRepository;

    @BeforeEach
    void setUp() {
        foodService = new FoodService(mockRepository);
    }

    @DisplayName("Testing getting list of all foods")
    @Test
    void getFoods() {
        Food mockFood = new Food();
        mockFood.setId("1");
        mockFood.setName("Pizza");
        mockFood.setDelicious(true);
        mockFood.setCanICookIt(true);

        Food mockFood2 = new Food();
        mockFood.setId("2");
        mockFood.setName("Hamburger");
        mockFood.setDelicious(true);
        mockFood.setCanICookIt(true);

        when(mockRepository.findAll())
                .thenReturn(Arrays.asList(mockFood, mockFood2));

        List<Food> actual = foodService.getFoods();

        assertEquals(mockFood.getName(), actual.get(0).getName());
        assertTrue(actual.get(0).isDelicious());

        assertEquals(mockFood2.getName(), actual.get(1).getName());
        assertFalse(mockFood2.isDelicious());

        verify(mockRepository, times(1)).findAll();
    }

    @Test
    void saveNewFood() {
        Food mockFood = new Food();
        mockFood.setId("1");
        mockFood.setName("Pizza");
        mockFood.setDelicious(true);
        mockFood.setCanICookIt(true);

        when(mockRepository.save(mockFood))
                .thenReturn(mockFood);

        Food food = foodService.saveNewFood(mockFood);

        assertEquals(food, mockFood);

        verify(mockRepository, times(1)).save(any());
    }

    @Test
    void saveNewFood_invalid() {
        Food mockFood = new Food();

        assertThrows(ResponseStatusException.class, () -> foodService.saveNewFood(mockFood));

        verify(mockRepository, times(0)).save(any());
    }

    @Test
    void getCookableFoods() {
        Food mockFood = new Food();
        mockFood.setId("1");
        mockFood.setName("Pizza");
        mockFood.setDelicious(true);
        mockFood.setCanICookIt(true);


        when(mockRepository.findFoodByCanICookIt(true))
                .thenReturn(Arrays.asList(mockFood));

        List<String> foods = foodService.getCookableFoods();

        assertEquals(foods.get(0), mockFood.getName());

    }
}