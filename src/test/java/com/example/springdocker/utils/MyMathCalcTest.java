package com.example.springdocker.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyMathCalcTest {

    private MyMathCalc myMathCalc;

    @BeforeEach
    void start() {
        myMathCalc = new MyMathCalc();
    }

    @DisplayName("Testing addition method")
    @Test
    void testAddition(){
        int expected = 2;
        int notExpected = 1000;
        int actual = myMathCalc.add(1,1);

        assertEquals(expected,actual);
        assertNotEquals(notExpected,actual);
    }

    @DisplayName("Testing subtract method")
    @Test
    void testSubtract() {
        int expected = 1;
        int notExpected = 1000;
        int actual = myMathCalc.subtract(2,1);

        assertEquals(expected,actual);
        assertNotEquals(notExpected,actual);
    }

    @DisplayName("Testing multiply method")
    @Test
    void testMultiply() {
        int expected = 10;
        int notExpected = 1000;
        int actual = myMathCalc.multiply(2,5);

        assertEquals(expected,actual);
        assertNotEquals(notExpected,actual);
    }

    @DisplayName("Testing divide method")
    @Test
    void testDivide() {
        int expected = 5;
        int notExpected = 1000;
        double actual = myMathCalc.divide(10,2);

        assertEquals(expected,actual);
        assertNotEquals(notExpected,actual);
    }

    @DisplayName("Testing divide method with decimal outcome")
    @Test
    void testDivide2() {
        double expected = 0.2;
        int notExpected = 1000;
        double actual = myMathCalc.divide(2,10);

        assertEquals(expected,actual);
        assertNotEquals(notExpected,actual);
    }

    @DisplayName("Testing divide method, dividing with 0")
    @Test
    void testDivide3() {
        assertThrows(NumberFormatException.class,() -> myMathCalc.divide(10,0));
    }
}
