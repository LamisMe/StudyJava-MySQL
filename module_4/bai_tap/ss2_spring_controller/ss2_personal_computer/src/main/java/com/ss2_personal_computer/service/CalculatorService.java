package com.ss2_personal_computer.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {

    @Override
    public double total(int first_number, int second_number, String allowable) {
        if (allowable.equals("+")) {
            return first_number + second_number;
        } else if (allowable.equals("-")) {
            return first_number - second_number;
        } else if (allowable.equals("*")) {
            return first_number * second_number;
        } else {
            return (double) first_number / second_number;
        }
    }
}
