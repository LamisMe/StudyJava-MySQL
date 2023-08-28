package com.example.ss9_calculator.service;

import java.util.Scanner;

public class DiscountService implements IDiscountService {
    @Override
    public double resultDiscount(double price, double discount) {
        double result;
        return result = price * discount * 0.01;
    }
}
