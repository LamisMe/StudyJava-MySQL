package com.example.ss10_excercise_1.service;

import com.example.ss10_excercise_1.model.Customer;
import com.example.ss10_excercise_1.repository.CustomerRepository;
import com.example.ss10_excercise_1.repository.ICustomerRepository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CustomerService implements ICustomerService {
    private ICustomerRepository customerRepository = new CustomerRepository();

    @Override
    public List<Customer> displayCustomer() {
        List<Customer> customers = new ArrayList<>();
        Map<Integer, Customer> customerMap =customerRepository.getAllCustomer();
        for (Map.Entry<Integer,Customer> entry: customerMap.entrySet()) {
            customers.add(entry.getValue());
        }
        return customers;
    }
}
