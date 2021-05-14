package com.example.springdocker.utils;

public class MyMathCalc {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) { return a -b; }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(double numberToDivide, double divideWith){
        if (divideWith == 0){
            throw new NumberFormatException("You can't divide with 0");
        }else {
            return numberToDivide / divideWith;
        }

    }
}
