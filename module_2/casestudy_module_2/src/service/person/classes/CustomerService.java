package service.person.classes;

import model.person.sub_class.Customer;
import repository.person.IPersonRepository;
import repository.person.classes.CustomerRepository;
import service.person.IPersonService;
import utils.IdNotFoundException;
import utils.ValidatePerson;

import java.util.List;
import java.util.Scanner;

public class CustomerService implements IPersonService {
    private final IPersonRepository<Customer> customerIPersonRepository = new CustomerRepository();

    @Override
    public void read() {
        List<Customer> customerList = customerIPersonRepository.getAll();
        if (customerList.isEmpty()) {
            System.out.println("Hệ thống chưa có dữ liệu");
        } else {
            for (Customer customer : customerList) {
                System.out.println(customer);
            }
        }
    }

    @Override
    public void create() {
        System.out.println("Nhập mã khách hàng (theo định dạng: KH-YYYY, với YYYY là số tư 0-9)");
        String id = ValidatePerson.getValidateIdCustomer();
        System.out.println("Nhập tên khách hàng (Phải viết hoa ký tự đầu của mỗi từ)");
        String name = ValidatePerson.getValidateNamePerson();
        System.out.println("Nhập ngày sinh khách hàng (Phải đủ 18 tuổi tính cả ngày + tháng)");
        String dateOfBirth = ValidatePerson.getValidateDate();
        String gender = ValidatePerson.getGenderPerson();
        System.out.println("Nhập số CMND (Phải đủ 9 hoặc 12 số)");
        String idCard = ValidatePerson.getValidateIdCard();
        System.out.println("Nhập số điện thoại (Bắt đầu bằng 0 và có đủ 10 số)");
        String phoneNumber = ValidatePerson.getValidatePhoneNumber();
        System.out.println("Nhập email khách hàng");
        String email = ValidatePerson.getValidateEmail();
        String typeCustomer = ValidatePerson.getTypeCustomer();
        String address = ValidatePerson.getAddress();
        Customer customer = new Customer(id, name, dateOfBirth, gender, idCard, phoneNumber, email, typeCustomer, address);
        customerIPersonRepository.add(customer);
    }

    @Override
    public void delete() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã khách hàng mà bạn muốn xóa");
        do {
            String id = scanner.nextLine();
            try {
                Customer customer = customerIPersonRepository.getById(id);
                if (customer == null) {
                    throw new IdNotFoundException("Khách hàng không tồn tại ");
                } else {
                    System.out.println("Bạn có chắc chắn muốn xóa " + customer.getName());
                    System.out.println("1.OK");
                    System.out.println("2.Cancel");
                    String select = scanner.nextLine();
                    if (select.equals("1")) {
                        customerIPersonRepository.remove(customer);
                        return;
                    } else {
                        break;
                    }
                }
            } catch (IdNotFoundException e) {
                System.out.println(e.getMessage());
            }

        } while (true);
    }

    @Override
    public void searchByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên khách hàng mà bạn muốn tìm kiếm");
        String name = scanner.nextLine();
        List<Customer> customerList = customerIPersonRepository.searchByName(name);
        if (customerList.isEmpty()) {
            System.out.println("Không có tên khách hàng trong hệ thống");
        } else {
            for (Customer customer : customerList) {
                System.out.println(customer);
            }
        }
    }

    @Override
    public void update() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã khách hàng cần cập nhật thông tin");
        do {
            String id = scanner.nextLine();
            try {
                Customer customer = customerIPersonRepository.getById(id);
                if (customer == null) {
                    throw new IdNotFoundException("Khách hàng không tồn tại ");
                } else {
                    do {
                        System.out.println("Chọn thông tin cần sửa");
                        System.out.println("1.Họ tên");
                        System.out.println("2.Ngày sinh");
                        System.out.println("3.Giới tính");
                        System.out.println("4.Số CMND");
                        System.out.println("5.Số điện thoại");
                        System.out.println("6.Email");
                        System.out.println("7.Loại khách");
                        System.out.println("8.Địa chỉ");
                        System.out.println("0.Lưu thông tin");
                        String select = scanner.nextLine();
                        switch (select) {
                            case "1":
                                System.out.println("Nhập tên khách hàng (Phải viết hoa ký tự đầu của mỗi từ)");
                                String name = ValidatePerson.getValidateNamePerson();
                                customer.setName(name);
                                break;
                            case "2":
                                System.out.println("Nhập ngày sinh khách hàng (Phải đủ 18 tuổi tính cả ngày + tháng)");
                                String dateOfBirth = ValidatePerson.getValidateDate();
                                customer.setDateOfBirth(dateOfBirth);
                                break;
                            case "3":
                                String gender = ValidatePerson.getGenderPerson();
                                customer.setGender(gender);
                                break;
                            case "4":
                                System.out.println("Nhập số CMND (Phải đủ 9 hoặc 12 số)");
                                String idCard = ValidatePerson.getValidateIdCard();
                                customer.setIdCard(idCard);
                                break;
                            case "5":
                                System.out.println("Nhập số điện thoại (Bắt đầu bằng 0 và có đủ 10 số)");
                                String phoneNumber = ValidatePerson.getValidatePhoneNumber();
                                customer.setPhoneNumber(phoneNumber);
                                break;
                            case "6":
                                System.out.println("Nhập email khách hàng");
                                String email = ValidatePerson.getValidateEmail();
                                customer.setEmail(email);
                                break;
                            case "7":
                                String typeCustomer = ValidatePerson.getTypeCustomer();
                                customer.setCustomerType(typeCustomer);
                                break;
                            case "8":
                                String address = ValidatePerson.getAddress();
                                customer.setAddress(address);
                                break;
                            case "0":
                                customerIPersonRepository.edit(id, customer);
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
