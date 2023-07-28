package repository.person.classes;

import common.ReadToFile;
import common.WriteToFile;
import model.person.sub_class.Employee;
import repository.person.IPersonRepository;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IPersonRepository<Employee> {
    private static final String PATH_EMPLOYEE = "src/data/employee.csv ";

    @Override
    public List<Employee> getAll() {
        List<String> stringList = ReadToFile.readToFile(PATH_EMPLOYEE);
        List<Employee> employeeList = new ArrayList<>();
        String[] info;
        try {
            for (String str : stringList) {
                info = str.split(",");
                employeeList.add(new Employee(info[0], info[1], info[2], info[3], info[4], info[5], info[6], info[7], info[8], Long.parseLong(info[9])));
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        return employeeList;
    }

    @Override
    public void add(Employee employee) {
        List<String> stringList = ReadToFile.readToFile(PATH_EMPLOYEE);
        stringList.add(employee.toInfoCSVEmployee());
        WriteToFile.writeToFile(PATH_EMPLOYEE, stringList, true);
    }

    @Override
    public void remove(Employee employee) {
        List<String> stringList = ReadToFile.readToFile(PATH_EMPLOYEE);
        List<Employee> employeeList = getAll();
        employeeList.remove(employee);
        for (Employee employees : employeeList) {
            stringList.add(employees.toInfoCSVEmployee());
        }
        WriteToFile.writeToFile(PATH_EMPLOYEE, stringList, false);
    }

    @Override
    public List<Employee> searchByName(String name) {
        List<Employee> employeeList = new ArrayList<>();
        List<Employee> employees = getAll();
        for (Employee employee:employees) {
            if(employee.getName().contains(name)){
                employeeList.add(employee);
            }
        }
        return employeeList;
    }

    @Override
    public void edit(String id, Employee employee) {
        List<Employee> employeeList = getAll();
        List<String> stringList = new ArrayList<>();
        for (Employee emp:employeeList) {
            if(emp.getId().equals(id)){
                emp = employee;
            }
            stringList.add(emp.toInfoCSVEmployee());
        }
        WriteToFile.writeToFile(PATH_EMPLOYEE,stringList,false);
    }

    @Override
    public Employee getById(String id) {
        List<Employee> employeeList = getAll();
        for (Employee employee: employeeList) {
            if(employee.getId().equals(id)){
                return employee;
            }
        }
        return null;
    }
}
