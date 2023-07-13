package ss10_dsa_danh_sach.arraylist.mvc.service;

import ss10_dsa_danh_sach.arraylist.mvc.model.Customer;
import ss10_dsa_danh_sach.arraylist.mvc.repository.CustomerRepository;
import ss10_dsa_danh_sach.arraylist.mvc.repository.ICustomerRepository;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CustomerService implements ICustomerService{
    private final Scanner scanner = new Scanner(System.in);
    private final ICustomerRepository customerRepository = new CustomerRepository();
    public void read() {
        List<Customer> customerList = customerRepository.display();
        for (Customer customer: customerList) {
            System.out.println(customer);
        }
    }

    @Override
    public void create() {
        System.out.println("Nhập mã khách hàng");
        int code = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên khách hàng");
        String name = scanner.nextLine();
        System.out.println("Nhập tuổi khách hàng");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập loại khách hàng");
        String typeCustomer = scanner.nextLine();
        Customer customer = new Customer(code,name,age,typeCustomer);
        customerRepository.add(customer);
        System.out.println("Thêm mới thành công");
    }

    @Override
    public void remove() {
        System.out.println("Nhập mã khách hàng mà bạn muốn xóa");
        int code = Integer.parseInt(scanner.nextLine());
        Customer customer = customerRepository.getById(code);
        if(customer == null){
            System.out.println("Mã khách hàng không tồn tại");
        }else {
            customerRepository.remove(customer);
            System.out.println("Xóa thành công");
        }

    }

    @Override
    public void update() {
        System.out.println("Nhập mã khách hàng mà bạn muốn sửa");
        int code = Integer.parseInt(scanner.nextLine());
        Customer customer = customerRepository.getById(code);
        if(customer == null){
            System.out.println("Mã khách hàng không tồn tại");
        }else {
            System.out.println("Chọn thông tin cần sửa");
            System.out.println("1.Tên");
            System.out.println("2.Tuổi");
            System.out.println("3.Loại khách hàng");
            System.out.println("0.Lưu thông tin");
            System.out.println("Chọn :");
            String choice = scanner.nextLine();
            switch (choice){
                case "1":
                    System.out.println("Nhập tên khách hàng");
                    String name = scanner.nextLine();
                    customer.setName(name);
                    break;
                case "2":
                    System.out.println("Nhập tuổi khách hàng");
                    int age = Integer.parseInt(scanner.nextLine());
                    customer.setAge(age);
                    break;
                case "3":
                    System.out.println("Nhập loại khách hàng");
                    String typeCustomer = scanner.nextLine();
                    customer.setTypeCustomer(typeCustomer);
                    break;
                case "0":
                    customerRepository.update(code,customer);
                    break;
                default:
                    System.out.println("Nhập sai nhập lại");
                    break;
            }
        }
    }

    @Override
    public void search() {
        System.out.println("Nhập tên khách hàng mà bạn muốn tìm");
        String name = scanner.nextLine();
        List<Customer> customerList = customerRepository.searchName(name);
        for (Customer customer: customerList) {
            System.out.println(customer);
        }if(customerList.isEmpty()){
            System.out.println("Không có tên khách hàng nào trùng với tên bạn nhập vào");
        }
    }

    @Override
    public void sort() {
        List<Customer> customerList = customerRepository.display();
        Collections.sort(customerList);
        for (Customer customer:customerList) {
            System.out.println(customer);
        }
    }
}
