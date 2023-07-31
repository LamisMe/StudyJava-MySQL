package utils;

import model.person.sub_class.Customer;
import model.person.sub_class.Employee;
import repository.person.IPersonRepository;
import repository.person.classes.CustomerRepository;
import repository.person.classes.EmployeeRepository;

import java.time.LocalDate;
import java.util.Scanner;

public class ValidatePerson {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String VALIDATE_ID_CUSTOMER = "^KH-\\d{4}$";
    private static final String VALIDATE_ID_EMPLOYEE = "^NV-\\d{4}$";
    private static final String VALIDATE_NAME_PERSON = "^[A-Z][a-z]{0,6}(\\s[A-Z][a-z]{1,6}){1,8}$";
    private static final String VALIDATE_DATE = "^((19|20)\\d\\d)/(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])$";
    private static final String VALIDATE_ID_CARD = "^\\d{9}|\\d{12}$";
    private static final String VALIDATE_PHONE_NUMBER = "^0\\d{9}$";
    private static final String VALIDATE_EMAIL = "^[a-zA-Z0-9]\\w{5,31}@[a-z]{1,11}\\.[a-z]{1,11}(\\.[a-z]{1,11})?$";


    public static String getValidateIdCustomer() {
        IPersonRepository<Customer> customerIPersonRepository = new CustomerRepository();
        do {
            try {
                String id = scanner.nextLine();
                if (id.matches(VALIDATE_ID_CUSTOMER)) {
                    Customer customer = customerIPersonRepository.getById(id);
                    if (customer == null) {
                        return id;
                    } else {
                        throw new UniqueIDException("Mã khách hàng đã tồn tại ");
                    }
                }
                System.out.println("Nhập sai định dạng");
            } catch (UniqueIDException uniqueIDException) {
                System.out.println(uniqueIDException.getMessage());
            }
        } while (true);
    }

    public static String getValidateIdEmployee() {
        IPersonRepository<Employee> employeeIPersonRepository = new EmployeeRepository();
        do {
            try {
                String id = scanner.nextLine();
                if (id.matches(VALIDATE_ID_EMPLOYEE)) {
                    Employee employee = employeeIPersonRepository.getById(id);
                    if (employee == null) {
                        return id;
                    } else {
                        throw new UniqueIDException("Mã khách hàng đã tồn tại ");
                    }
                }
                System.out.println("Nhập sai định dạng");
            } catch (UniqueIDException uniqueIDException) {
                System.out.println(uniqueIDException.getMessage());
            }
        } while (true);
    }

    public static String getValidateNamePerson() {
        do {
            String name = scanner.nextLine();
            if (name.matches(VALIDATE_NAME_PERSON)) {
                return name;
            }
            System.out.println("Nhập sai định dạng");
        } while (true);
    }

    public static String getValidateDate() {
        Scanner scanner = new Scanner(System.in);
        LocalDate localDate = LocalDate.now();
        String dateOfBirth;
        do {
            do {
                System.out.println("Nhập ngày sinh của bạn theo định dạng(yyyy/MM/dd)");
                dateOfBirth = scanner.nextLine();
                if (dateOfBirth.matches(VALIDATE_DATE)) {
                    break;
                } else {
                    System.out.println("Nhập sai định dạng");
                }
            } while (true);
            String[] info = new String[2];
            for (int i = 0; i < dateOfBirth.length(); i++) {
                info = dateOfBirth.split("/");
            }
            if (localDate.getYear() - Integer.parseInt(info[0]) >= 18) {
                if (Integer.parseInt(info[1]) - localDate.getMonthValue() < 0) {
                    System.out.println("Chưa được 18 tuổi");
                } else if (Integer.parseInt(info[2]) - localDate.getDayOfMonth() >= 0) {
                    System.out.println("Chưa được 18 tuổi");
                } else {
                    System.out.println("Đã đủ 18 tuổi");
                    return dateOfBirth;
                }
            } else {
                System.out.println("Chưa được 18 tuổi");
            }
        } while (true);
    }

    public static String getValidateIdCard() {
        do {
            String idCard = scanner.nextLine();
            if (idCard.matches(VALIDATE_ID_CARD)) {
                return idCard;
            } else {
                System.out.println("Nhập sai định dạng");
            }
        } while (true);
    }

    public static String getValidatePhoneNumber() {
        do {
            String phoneNumber = scanner.nextLine();
            if (phoneNumber.matches(VALIDATE_PHONE_NUMBER)) {
                return phoneNumber;
            }
            System.out.println("Nhập sai định dạng");
        } while (true);
    }

    public static String getGenderPerson() {
        String gender = "";
        do {
            System.out.println("Chọn giới tính");
            System.out.println("1.Nam");
            System.out.println("2.Nữ");
            System.out.println("3.###");
            String select = scanner.nextLine();
            switch (select) {
                case "1":
                    gender = "Nam";
                    return gender;
                case "2":
                    gender = "Nữ";
                    return gender;
                case "3":
                    gender = "###";
                    return gender;
                default:
                    System.out.println("Nhập sai yêu cầu");
                    break;
            }
        } while (true);
    }

    public static String getValidateEmail() {
        do {
            String email = scanner.nextLine();
            if (email.matches(VALIDATE_EMAIL)) {
                return email;
            }
            System.out.println("Nhập sai định dạng");
        } while (true);
    }

    public static String getTypeCustomer() {
        String typeCustomer = "";
        do {
            System.out.println("Chọn loại khách hàng");
            System.out.println("1.Kim cương");
            System.out.println("2.Bạch kim");
            System.out.println("3.Vàng");
            System.out.println("4.Bạc");
            System.out.println("5.Thành viên");
            String select = scanner.nextLine();
            switch (select) {
                case "1":
                    typeCustomer = "Kim cương";
                    return typeCustomer;
                case "2":
                    typeCustomer = "Bạch kim";
                    return typeCustomer;
                case "3":
                    typeCustomer = "Vàng";
                    return typeCustomer;
                case "4":
                    typeCustomer = "Bạc";
                    return typeCustomer;
                case "5":
                    typeCustomer = "Thành viên";
                    return typeCustomer;
                default:
                    System.out.println("Nhập sai yêu cầu");
                    break;
            }
        } while (true);
    }

    public static String getLevelEmployee() {
        String level = "";
        do {
            System.out.println("Chọn trình độ nhân viên");
            System.out.println("1.Trung cấp");
            System.out.println("2.Cao đẳng");
            System.out.println("3.Đại học");
            System.out.println("4.Sau đại học");
            String select = scanner.nextLine();
            switch (select) {
                case "1":
                    level = "Trung cấp";
                    return level;
                case "2":
                    level = "Cao đẳng";
                    return level;
                case "3":
                    level = "Đại học";
                    return level;
                case "4":
                    level = "Sau đại học";
                    return level;
                default:
                    System.out.println("Nhập sai yêu cầu");
                    break;
            }
        } while (true);
    }

    public static String getLocationEmployee() {
        String location = "";
        do {
            System.out.println("Chọn vị trí nhân viên");
            System.out.println("1.Lễ tân");
            System.out.println("2.Phục vụ");
            System.out.println("3.Chuyên viên");
            System.out.println("4.Giám sát");
            System.out.println("5.Quản lý");
            System.out.println("6.Giám đốc");
            String select = scanner.nextLine();
            switch (select) {
                case "1":
                    location = "Lễ tân";
                    return location;
                case "2":
                    location = "Phục vụ";
                    return location;
                case "3":
                    location = "Chuyên viên";
                    return location;
                case "4":
                    location = "Giám sát";
                    return location;
                case "5":
                    location = "Quản lý";
                    return location;
                case "6":
                    location = "Giám đốc";
                    return location;
                default:
                    System.out.println("Nhập sai yêu cầu");
                    break;
            }
        } while (true);
    }

    public static long getSalary() {
        do {
            try {
                long salary = Long.parseLong(scanner.nextLine());
                if (salary > 0) {
                    return salary;
                }
                throw new NumberFormatException("Nhập sai định dạng");
            } catch (NumberFormatException numberFormatException) {
                System.out.println(numberFormatException.getMessage());
            }
        } while (true);
    }

    public static String getAddress() {
        System.out.println("Nhập địa chỉ khách hàng");
        String address = scanner.nextLine();
        String[] strings = new String[0];
        for (int i = 0; i < address.length(); i++) {
            strings = address.split(",");
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            stringBuilder.append(strings[i]);
            stringBuilder.append("-");
        }
        return String.valueOf(stringBuilder);
    }
}
