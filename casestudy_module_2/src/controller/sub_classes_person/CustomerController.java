package controller.sub_classes_person;

import java.util.Scanner;

public class CustomerController {
    private final Scanner scanner = new Scanner(System.in);
    public void showMenuCustomer() {
        do {
            System.out.println();
            System.out.println("-----------Quản lý Khách Hàng------------");
            System.out.println("1.Hiển thị danh sách khách hàng");
            System.out.println("2.Thêm mới khách hàng");
            System.out.println("3.Chỉnh sửa thông tin khách hàng");
            System.out.println("4.Xóa khách hàng");
            System.out.println("5.Tìm kiếm theo tên khách hàng");
            System.out.println("6.Quay lại trang trước");
            System.out.print("Chọn chức năng: ");
            String select = scanner.nextLine();
            switch (select) {
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                    return;
                default:
                    System.out.println("Nhập sai nhập lại");
                    break;
            }
        }while (true);
    }
}
