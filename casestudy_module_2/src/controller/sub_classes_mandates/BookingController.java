package controller.sub_classes_mandates;

import utils.ColorInConsole;

import java.util.Scanner;

public class BookingController
{
    private final Scanner scanner = new Scanner(System.in);

    public void showMenuBooking() {
        do {
            System.out.println(
                    ColorInConsole.ANSI_GREEN
                            + "\n---------------------------------------------------"
                            + ColorInConsole.ANSI_BLUE
            );
            System.out.println(
                    "|             ----- Quản lý Booking -----         |"
                            + ColorInConsole.ANSI_BLUE
            );

            System.out.println("|               1.Thêm mới Booking                |\n" +
                    "|               2.Hiển thị danh sách Booking      |\n" +
                    "|               3.Tạo hợp đồng mới                |\n" +
                    "|               4.Hiển thị danh sách hợp đồng     |\n" +
                    "|               5.Chỉnh sửa thông tin hợp đồng    |\n" +
                    "|               6.Quay lại trang trước            |");
            System.out.println(ColorInConsole.ANSI_GREEN +
                    "\n---------------------------------------------------"
                    + ColorInConsole.ANSI_BLUE
            );
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
