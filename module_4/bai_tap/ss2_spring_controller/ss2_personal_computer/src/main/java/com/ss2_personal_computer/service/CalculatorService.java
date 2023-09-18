package com.ss2_personal_computer.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {

    @Override
    public double total(int firstNumber, int secondNumber, String allowable) {
        if (allowable.equals("+")) {
            return firstNumber + secondNumber;
        } else if (allowable.equals("-")) {
            return firstNumber - secondNumber;
        } else if (allowable.equals("*")) {
            return firstNumber * secondNumber;
        } else if (allowable.equals("/")) {
            if (secondNumber != 0) {
                return (double) firstNumber / secondNumber;
            } else {
                return -1;
            }
        } else {
            return -99;
        }
    }
}
