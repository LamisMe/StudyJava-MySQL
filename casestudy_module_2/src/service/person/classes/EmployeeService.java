package service.person.classes;

import model.person.sub_class.Employee;
import repository.person.IPersonRepository;
import repository.person.classes.EmployeeRepository;
import service.person.IPersonService;
import utils.IdNotFoundException;
import utils.Regex;

import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IPersonService {
    private final IPersonRepository<Employee> employeeIPersonRepository = new EmployeeRepository();

    @Override
    public void read() {
        List<Employee> employees = employeeIPersonRepository.getAll();
        if (employees.isEmpty()) {
            System.out.println("Hệ thống chưa có dữ liệu");
        } else {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    @Override
    public void create() {
        System.out.println("Nhập mã nhân viên(Theo định dạng NV-YYYY, với YYYY là số tư 0-9)");
        String id = Regex.getValidateIdEmployee();
        System.out.println("Nhập tên nhân viên (Phải viết hoa ký tự đầu của mỗi từ)");
        String name = Regex.getValidateNamePerson();
        System.out.println("Nhập ngày sinh nhân viên (Phải đủ 18 tuổi tính cả ngày + tháng)");
        String dateOfBirth = Regex.getValidateDate();
        String gender = Regex.getGenderPerson();
        System.out.println("Nhập số CMND (Phải đủ 9 hoặc 12 số)");
        String idCard = Regex.getValidateIdCard();
        System.out.println("Nhập số điện thoại (Bắt đầu bằng 0 và có đủ 10 số)");
        String phoneNumber = Regex.getValidatePhoneNumber();
        System.out.println("Nhập email nhân viên");
        String email = Regex.getValidateEmail();
        String level = Regex.getLevelEmployee();
        String location = Regex.getLocationEmployee();
        System.out.println("Nhập lương của nhân viên");
        long salary = Regex.getSalary();
        Employee employee = new Employee(id, name, dateOfBirth, gender, idCard, phoneNumber, email, level, location, salary);
        employeeIPersonRepository.add(employee);
    }

    @Override
    public void delete() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã nhân viên mà bạn muốn xóa");
        do {
            String id = scanner.nextLine();
            try {
                Employee employee = employeeIPersonRepository.getById(id);
                if (employee == null) {
                    throw new IdNotFoundException("Nhân viên không tồn tại");
                }else {
                    System.out.println("Bạn có chắc chắn muốn xóa "+ employee.getName());
                    System.out.println("1.OK");
                    System.out.println("2.Cancel");
                    String select = scanner.nextLine();
                    if (select.equals("1")){
                        employeeIPersonRepository.remove(employee);
                        return;
                    }else {
                        break;
                    }
                }
            } catch (IdNotFoundException e) {
                throw new RuntimeException(e);
            }

        } while (true);
    }

        @Override
        public void searchByName () {
            Scanner scanner = new Scanner(System.in);
        }

        @Override
        public void update () {
            Scanner scanner = new Scanner(System.in);
        }
    }
