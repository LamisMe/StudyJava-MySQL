package controller.sub_classes_person;

import java.util.Scanner;

public class EmployeeController {
    private final Scanner scanner = new Scanner(System.in);

    public void showMenuEmployee() {
        do {
            System.out.println();
            System.out.println("-----------Quản lý Nhân Viên------------");
            System.out.println("1.Hiển thị danh sách nhân viên");
            System.out.println("2.Thêm mới nhân viên");
            System.out.println("3.Chỉnh sửa thông tin nhân viên");
            System.out.println("4.Xóa nhân viên");
            System.out.println("5.Tìm kiếm theo tên nhân viên");
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
