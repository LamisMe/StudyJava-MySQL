package ss10_dsa_danh_sach.arraylist.mvc.controller;

import ss10_dsa_danh_sach.arraylist.mvc.service.CustomerService;
import ss10_dsa_danh_sach.arraylist.mvc.service.ICustomerService;

import java.util.Scanner;

public class CustomerController {
    private Scanner scanner = new Scanner(System.in);
    private ICustomerService customerService = new CustomerService();
    public void showMenu(){
        do {
            System.out.println("----Quản lý Khách Hàng-----");
            System.out.println("1.Hiển thị danh sách khách hàng");
            System.out.println("2.Thêm");
            System.out.println("3.Xóa");
            System.out.println("4.Sửa");
            System.out.println("5.Tim kiếm theo tên");
            System.out.println("6.Sắp xếp theo tên");
            System.out.println("0.Thoát");
            System.out.println("Chọn chức năng: ");
            String choice = scanner.nextLine();
            switch (choice){
                case "1":
                    customerService.read();
                    break;
                case "2":
                    customerService.create();
                    break;
                case "3":
                    customerService.remove();
                    break;
                case "4":
                    customerService.update();
                    break;
                case "5":
                    customerService.search();
                    break;
                case "6":
                    customerService.sort();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Nhập sai nhập lại");
                    break;
            }
        }while (true);
    }
}
