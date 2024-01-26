package controller.sub_classes_mandates;

import service.booking.IBookingService;
import service.booking.classes.BookingService;
import utils.ColorInConsole;

import java.util.Scanner;

public class BookingController {
    private final Scanner scanner = new Scanner(System.in);
    private final IBookingService bookingService = new BookingService();

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
                    bookingService.addBooking();
                    break;
                case "2":
                    bookingService.displayBooking();
                    break;
                case "3":
                    bookingService.creatContract();
                    break;
                case "4":
                    bookingService.displayContract();
                    break;
                case "5":
                    bookingService.editContract();
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Nhập sai nhập lại");
                    break;
            }
        } while (true);
    }
}
