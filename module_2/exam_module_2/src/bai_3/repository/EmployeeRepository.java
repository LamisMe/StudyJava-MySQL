package bai_3.repository;

import bai_3.common.ReadAndWriteFile;
import bai_3.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private static final String PATH_EMPLOYEE = "src/bai_3/data/nhanvien.csv";
    private List<Employee> employeeList = new ArrayList<>();

    @Override
    public List<Employee> getAll() {
        List<String> stringList = ReadAndWriteFile.readToFile(PATH_EMPLOYEE);
        employeeList.clear();
        String[] info;
        try {
            for (String str : stringList) {
                info = str.split(",");
                employeeList.add(new Employee(info[0], info[1], info[2], info[3], Long.parseLong(info[4])));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception ArrayIndexOutOfBounds");
        }
        return employeeList;
    }

    @Override
    public void add(Employee employee) {
        List<String> stringList = ReadAndWriteFile.readToFile(PATH_EMPLOYEE);
        stringList.add(employee.infoToCSVEmployee());
        ReadAndWriteFile.writeToFile(PATH_EMPLOYEE, stringList, false);
    }

    @Override
    public Employee getByID(String codeEmployee) {
        List<Employee> employees = getAll();
        for (Employee employee : employees) {
            if (employee.getCodeEmployee().equals(codeEmployee)) {
                return employee;
            }
        }
        return null;
    }
}
