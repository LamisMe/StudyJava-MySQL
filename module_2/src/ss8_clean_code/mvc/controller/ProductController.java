package ss8_clean_code.mvc.controller;

import ss8_clean_code.mvc.service.IProductService;
import ss8_clean_code.mvc.service.ProductService;

import java.util.Scanner;

public class ProductController {
    private final Scanner scanner = new Scanner(System.in);
    private final IProductService productService = new ProductService();
    public void displayMenu(){
        do {
            System.out.print("------Quản lý sản phẩm---------");
            System.out.print("1.Thêm sản phẩm");
            System.out.print("2.Hiển thị sản phẩm");
            System.out.print("3.Sửa sản phẩm");
            System.out.print("4.Xóa sản phẩm");
            System.out.print("0.Thoát");
            System.out.print("Chọn chức năng");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                case "2":
                case "3":
                case "4":
                case "0":
                    return;
                default:
                    System.out.println("Nhập sai nhâp lại");
                    break;
            }
        }while (true);
    }
}
