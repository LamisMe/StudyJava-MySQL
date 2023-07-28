package service.person.classes;

import model.person.sub_class.Customer;
import model.person.sub_class.Employee;
import repository.person.IPersonRepository;
import repository.person.classes.CustomerRepository;
import service.person.IPersonService;
import utils.IdNotFoundException;
import utils.Regex;

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
        String id = Regex.getValidateIdCustomer();
        System.out.println("Nhập tên khách hàng (Phải viết hoa ký tự đầu của mỗi từ)");
        String name = Regex.getValidateNamePerson();
        System.out.println("Nhập ngày sinh khách hàng (Phải đủ 18 tuổi tính cả ngày + tháng)");
        String dateOfBirth = Regex.getValidateDate();
        String gender = Regex.getGenderPerson();
        System.out.println("Nhập số CMND (Phải đủ 9 hoặc 12 số)");
        String idCard = Regex.getValidateIdCard();
        System.out.println("Nhập số điện thoại (Bắt đầu bằng 0 và có đủ 10 số)");
        String phoneNumber = Regex.getValidatePhoneNumber();
        System.out.println("Nhập email khách hàng");
        String email = Regex.getValidateEmail();
        String typeCustomer = Regex.getTypeCustomer();
        String address = Regex.getAddress();
        Customer customer = new Customer(id,name,dateOfBirth,gender,idCard,phoneNumber,email,typeCustomer,address);
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
                }else {
                    System.out.println("Bạn có chắc chắn muốn xóa "+ customer.getName());
                    System.out.println("1.OK");
                    System.out.println("2.Cancel");
                    String select = scanner.nextLine();
                    if (select.equals("1")){
                        customerIPersonRepository.remove(customer);
                        return;
                    }else {
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
    }

    @Override
    public void update() {
        Scanner scanner = new Scanner(System.in);
    }
}
