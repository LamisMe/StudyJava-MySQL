package bai_3.repository;

import bai_3.model.Employee;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> getAll();
    void add(Employee employee);
    Employee getByID(String codeEmployee);
}
