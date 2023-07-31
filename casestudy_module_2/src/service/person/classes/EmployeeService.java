package service.person.classes;

import model.person.sub_class.Employee;
import repository.person.IPersonRepository;
import repository.person.classes.EmployeeRepository;
import service.person.IPersonService;
import utils.IdNotFoundException;
import utils.ValidatePerson;

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
        String id = ValidatePerson.getValidateIdEmployee();
        System.out.println("Nhập tên nhân viên (Phải viết hoa ký tự đầu của mỗi từ)");
        String name = ValidatePerson.getValidateNamePerson();
        System.out.println("Nhập ngày sinh nhân viên (Phải đủ 18 tuổi tính cả ngày + tháng)");
        String dateOfBirth = ValidatePerson.getValidateDate();
        String gender = ValidatePerson.getGenderPerson();
        System.out.println("Nhập số CMND (Phải đủ 9 hoặc 12 số)");
        String idCard = ValidatePerson.getValidateIdCard();
        System.out.println("Nhập số điện thoại (Bắt đầu bằng 0 và có đủ 10 số)");
        String phoneNumber = ValidatePerson.getValidatePhoneNumber();
        System.out.println("Nhập email nhân viên");
        String email = ValidatePerson.getValidateEmail();
        String level = ValidatePerson.getLevelEmployee();
        String location = ValidatePerson.getLocationEmployee();
        System.out.println("Nhập lương của nhân viên");
        long salary = ValidatePerson.getSalary();
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
                } else {
                    System.out.println("Bạn có chắc chắn muốn xóa " + employee.getName());
                    System.out.println("1.OK");
                    System.out.println("2.Cancel");
                    String select = scanner.nextLine();
                    if (select.equals("1")) {
                        employeeIPersonRepository.remove(employee);
                        return;
                    } else {
                        break;
                    }
                }
            } catch (IdNotFoundException e) {
                throw new RuntimeException(e);
            }

        } while (true);
    }

    @Override
    public void searchByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên nhân viên mà bạn muốn tìm kiếm");
        String name = scanner.nextLine();
        List<Employee> employees = employeeIPersonRepository.searchByName(name);
        if (employees.isEmpty()) {
            System.out.println("Không có tên nhân viên trong hệ thống");
        } else {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    @Override
    public void update() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã nhân viên cần cập nhật thông tin");
        do {
            String id = scanner.nextLine();
            try {
                Employee employee = employeeIPersonRepository.getById(id);
                if (employee == null) {
                    throw new IdNotFoundException("Nhân viên không tồn tại ");
                } else {
                    do {
                        System.out.println("Chọn thông tin cần sửa");
                        System.out.println("1.Họ tên");
                        System.out.println("2.Ngày sinh");
                        System.out.println("3.Giới tính");
                        System.out.println("4.Số CMND");
                        System.out.println("5.Số điện thoại");
                        System.out.println("6.Email");
                        System.out.println("7.Trình độ");
                        System.out.println("8.Vị trí");
                        System.out.println("9.Lương");
                        System.out.println("0.Lưu thông tin");
                        String select = scanner.nextLine();
                        switch (select) {
                            case "1":
                                System.out.println("Nhập tên nhân viên (Phải viết hoa ký tự đầu của mỗi từ)");
                                String name = ValidatePerson.getValidateNamePerson();
                                employee.setName(name);
                                break;
                            case "2":
                                System.out.println("Nhập ngày sinh nhân viên (Phải đủ 18 tuổi tính cả ngày + tháng)");
                                String dateOfBirth = ValidatePerson.getValidateDate();
                                employee.setDateOfBirth(dateOfBirth);
                                break;
                            case "3":
                                String gender = ValidatePerson.getGenderPerson();
                                employee.setGender(gender);
                                break;
                            case "4":
                                System.out.println("Nhập số CMND (Phải đủ 9 hoặc 12 số)");
                                String idCard = ValidatePerson.getValidateIdCard();
                                employee.setIdCard(idCard);
                                break;
                            case "5":
                                System.out.println("Nhập số điện thoại (Bắt đầu bằng 0 và có đủ 10 số)");
                                String phoneNumber = ValidatePerson.getValidatePhoneNumber();
                                employee.setPhoneNumber(phoneNumber);
                                break;
                            case "6":
                                System.out.println("Nhập email nhân viên");
                                String email = ValidatePerson.getValidateEmail();
                                employee.setEmail(email);
                                break;
                            case "7":
                                String level = ValidatePerson.getLevelEmployee();
                                employee.setLevel(level);
                                break;
                            case "8":
                                String location = ValidatePerson.getLocationEmployee();
                                employee.setLocation(location);
                                break;
                            case "9":
                                long salary = ValidatePerson.getSalary();
                                employee.setWage(salary);
                                break;
                            case "0":
                                employeeIPersonRepository.edit(id, employee);
                                return;
                            default:
                                System.out.println("Nhập sai định dạng");
                                break;
                        }
                    } while (true);
                }
            } catch (IdNotFoundException e) {
                System.out.println(e.getMessage());
            }

        } while (true);
    }
}
