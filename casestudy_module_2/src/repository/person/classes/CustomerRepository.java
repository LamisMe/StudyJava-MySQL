package repository.person.classes;

import common.ReadToFile;
import common.WriteToFile;
import model.person.sub_class.Customer;
import repository.person.IPersonRepository;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements IPersonRepository<Customer> {
    private static final String PATH_CUSTOMER = "src/data/customer.csv";

    @Override
    public List<Customer> getAll() {
        List<String> stringList = ReadToFile.readToFile(PATH_CUSTOMER);
        List<Customer> customerList = new ArrayList<>();
        String[] info;
        try {
            for (String str : stringList) {
                info = str.split(",");
                customerList.add(new Customer(info[0], info[1], info[2], info[3], info[4], info[5], info[6], info[7], info[8]));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        return customerList;
    }

    @Override
    public void add(Customer customer) {
        List<String> stringList = ReadToFile.readToFile(PATH_CUSTOMER);
        stringList.add(customer.getCustomerType());
        WriteToFile.writeToFile(PATH_CUSTOMER, stringList, true);
    }

    @Override
    public void remove(Customer customer) {
        List<Customer> customerList = getAll();
        customerList.remove(customer);
        List<String> stringList = new ArrayList<>();
        for (Customer customers : customerList) {
            stringList.add(customers.getCustomerType());
        }
        WriteToFile.writeToFile(PATH_CUSTOMER, stringList, false);
    }

    @Override
    public List<Customer> searchByName(String name) {
        List<Customer> customerList = new ArrayList<>();
        List<Customer> customers = getAll();
        for (Customer customer : customers) {
            if (customer.getName().contains(name)) {
                customerList.add(customer);
            }
        }
        return customerList;
    }

    @Override
    public void edit(String id, Customer customer) {
        List<Customer> customerList = getAll();
        List<String> stringList = new ArrayList<>();
        for (Customer customers : customerList) {
            if (customers.getId().equals(id)) {
                customers = customer;
            }
            stringList.add(customers.getCustomerType());
        }
        WriteToFile.writeToFile(PATH_CUSTOMER, stringList, false);
    }

    @Override
    public Customer getById(String id) {
        List<Customer> customerList = getAll();
        for (Customer customer : customerList) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
    }
}
