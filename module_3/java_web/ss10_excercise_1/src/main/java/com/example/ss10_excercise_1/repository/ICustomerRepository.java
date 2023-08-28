package com.example.ss10_excercise_1.repository;

import com.example.ss10_excercise_1.model.Customer;

import java.util.List;
import java.util.Map;

public interface ICustomerRepository {
    Map<Integer,Customer> getAllCustomer();
}
