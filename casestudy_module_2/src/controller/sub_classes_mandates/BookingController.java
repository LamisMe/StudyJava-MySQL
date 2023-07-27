package controller.sub_classes_mandates;

import java.util.Scanner;

public class BookingController
{
    private final Scanner scanner = new Scanner(System.in);

    public void showMenuBooking() {
        do {
            System.out.println();
            System.out.println("-------------Quản lý Booking-----------");
            System.out.println("1.Thêm mới Booking");
            System.out.println("2.Hiển thị danh sách Booking");
            System.out.println("3.Tạo hợp đồng mới");
            System.out.println("4.Hiển thị danh sách hợp đồng");
            System.out.println("5.Chỉnh sửa thông tin hợp đồng");
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
        } while (true);
    }
}
