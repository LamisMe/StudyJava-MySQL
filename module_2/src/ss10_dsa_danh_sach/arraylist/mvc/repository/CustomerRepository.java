package ss10_dsa_danh_sach.arraylist.mvc.repository;

import ss10_dsa_danh_sach.arraylist.mvc.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private static List<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer(1, "Hoang", 20, "Diamond"));
        customerList.add(new Customer(2, "Vuong", 23, "Gold"));
        customerList.add(new Customer(3, "Linh", 21, "Silver"));
    }

    @Override
    public List<Customer> display() {
        return customerList;
    }

    @Override
    public void add(Customer customer) {
        customerList.add(customer);
    }

    @Override
    public void remove(Customer customer) {
        customerList.remove(customer);
    }

    @Override
    public void update(int id, Customer customer) {
        customerList = display();
        for (Customer c : customerList) {
            if (c.getCode() == id) {
                c = customer;
            }
            customerList.add(c);
        }
    }

    @Override
    public List<Customer> searchName(String name) {
        customerList = display();
        List<Customer> customers = new ArrayList<>();
        for (Customer customer: customerList) {
            if(customer.getName().contains(name)){
                customers.add(customer);
            }
        }
        return customers;
    }

    @Override
    public Customer getById(int id) {
        customerList = display();
        for (Customer customer : customerList) {
            if (customer.getCode() == id) {
                return customer;
            }
        }
        return null;
    }
}
