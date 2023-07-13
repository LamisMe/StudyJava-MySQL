package ss10_dsa_danh_sach.mvc.controller;

import ss10_dsa_danh_sach.mvc.service.IProductService;
import ss10_dsa_danh_sach.mvc.service.ProductService;

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
