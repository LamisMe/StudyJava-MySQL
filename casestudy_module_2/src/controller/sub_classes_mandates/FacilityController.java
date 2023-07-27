package controller.sub_classes_mandates;

import java.util.Scanner;

public class FacilityController {
    private final Scanner scanner = new Scanner(System.in);

    public void showMenuFacility() {
        do {
            System.out.println();
            System.out.println("-------------Quản lý Cơ Sở-----------");
            System.out.println("1.Hiển thị danh sách cơ sở");
            System.out.println("2.Thêm mới cơ sở");
            System.out.println("3.Hiển thị danh sách bảo trì cơ sở");
            System.out.println("4.Xóa cơ sở");
            System.out.println("5.Quay lại trang trước");
            System.out.print("Chọn chức năng: ");
            String select = scanner.nextLine();
            switch (select) {
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                    return;
                default:
                    System.out.println("Nhập sai nhập lại");
                    break;
            }
        } while (true);
    }
}
