package ss17_io_binary_file.mvc.controller;

import ss17_io_binary_file.mvc.service.IProductService;
import ss17_io_binary_file.mvc.service.ProductService;

import java.util.Scanner;

public class ProductController {
    public static final String CHOICE_FIRST = "1";
    public static final String CHOICE_SECOND = "2";
    public static final String CHOICE_ZERO = "0";
    public static final String CHOICE_THIRD = "3";
    private final Scanner scanner = new Scanner(System.in);
    private final IProductService productService = new ProductService();
    public void showMenuProduct(){
        do {
            System.out.println("----Quản lý sản phẩm-----");
            System.out.println("1.Hiển thị danh sách sản phẩm");
            System.out.println("2.Thêm sản phẩm");
            System.out.println("3.Tìm kiếm sản phẩm");
            System.out.println("0.Exit");
            String choice = scanner.nextLine();
            switch (choice) {
                case CHOICE_FIRST:
                    productService.display();
                    break;
                case CHOICE_SECOND:
                    productService.add();
                    break;
                case CHOICE_THIRD:
                    productService.search();
                    break;
                case CHOICE_ZERO:
                default:
                    System.out.println("Nhập sai nhập lại");
                    break;
            }
        }while (true);
    }
}
