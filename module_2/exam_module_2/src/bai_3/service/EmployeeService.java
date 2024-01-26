package bai_3.service;

import bai_3.model.Employee;
import bai_3.repository.EmployeeRepository;
import bai_3.repository.IEmployeeRepository;

import java.util.*;

public class EmployeeService implements IEmployeeService {
    private final Scanner scanner = new Scanner(System.in);
    private final IEmployeeRepository employeeRepository = new EmployeeRepository();

    @Override
    public void display() {
        List<Employee> employees = employeeRepository.getAll();
        if (employees.isEmpty()) {
            System.out.println("Hệ thống chưa có dữ liệu");
        } else {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    @Override
    public void add() {
        System.out.println("Nhập mã nhân viên");
        String codeEmployee = scanner.nextLine();
        System.out.println("Nhập tên nhân viên");
        String nameEmployee = scanner.nextLine();
        System.out.println("Nhập ngày tháng năm sinh");
        String dateOfBirth = scanner.nextLine();
        String position = "";
        AD:
        do {
            System.out.println("Chọn vị trí");
            System.out.println("1.Giám đốc");
            System.out.println("2.Trưởng phòng");
            System.out.println("3.Vị trí khác");
            String select = scanner.nextLine();
            switch (select) {
                case "1":
                    position = "Giám đốc";
                    break AD;
                case "2":
                    position = "Trưởng phòng";
                    break AD;
                case "3":
                    position = "Vị trí khác";
                    break AD;
                default:
                    System.out.println("Nhập sai nhập lại");
                    break;
            }
        } while (true);
        long salary;
        do {
            System.out.println("Nhập lương của nhân viên");
            try {
                salary = Long.parseLong(scanner.nextLine());
                if (salary > 0) {
                    break;
                }
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Nhập sai");
            }
        } while (true);
        Employee employee = new Employee(codeEmployee, nameEmployee, dateOfBirth, position, salary);
        employeeRepository.add(employee);
    }

    @Override
    public void bonusEndYear() {
        List<Employee> employees = employeeRepository.getAll();
        Collections.sort(employees);
        Map<Employee, Integer> employeeIntegerMap = new LinkedHashMap<>();
        for (Employee employee : employees) {
            if (employee.getPosition().equals("Giám đốc")) {
                int bonus = (int) (employee.getSalary() * 200 / 100);
                employeeIntegerMap.put(employee, bonus);
            } else if (employee.getPosition().equals("Trưởng phòng")) {
                int bonus = (int) (employee.getSalary() * 150 / 100);
                employeeIntegerMap.put(employee, bonus);
            } else {
                int bonus = (int) (employee.getSalary() * 100 / 100);
                employeeIntegerMap.put(employee, bonus);
            }
        }
        for (Map.Entry<Employee, Integer> entry : employeeIntegerMap.entrySet()) {
            System.out.println(entry.getKey() + ", thưởng cuối năm: " + entry.getValue());
        }
    }
}
