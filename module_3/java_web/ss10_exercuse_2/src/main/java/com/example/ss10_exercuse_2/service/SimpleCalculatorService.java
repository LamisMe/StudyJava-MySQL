package com.example.ss10_exercuse_2.service;

public class SimpleCalculatorService {
    public double resultSimpleCalculator(double a, double b, String operator) {
        double result;
        if (operator.equals("+")) {
            return result = a + b;
        } else if (operator.equals("-")) {
            return result = a - b;
        } else if (operator.equals("*")) {
            return result = a * b;
        } else if (operator.equals("/")) {
            if (b == 0) {
                throw new RuntimeException("Can't divide by zero");
            } else {
                return result = a / b;
            }
        } else {
            throw new RuntimeException("Invalid operation");
        }

    }
}
