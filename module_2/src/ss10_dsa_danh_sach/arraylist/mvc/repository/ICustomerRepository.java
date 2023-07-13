package ss10_dsa_danh_sach.arraylist.mvc.repository;

import ss10_dsa_danh_sach.arraylist.mvc.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> display();
    void add(Customer customer);
    void remove(Customer customer);
    void update(int id,Customer customer);
    List<Customer> searchName(String name);
    Customer getById(int id);
}
