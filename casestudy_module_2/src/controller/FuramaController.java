package controller;

import controller.sub_classes_mandates.BookingController;
import controller.sub_classes_mandates.FacilityController;
import controller.sub_classes_mandates.PromotionController;
import controller.sub_classes_person.CustomerController;
import controller.sub_classes_person.EmployeeController;
import utils.ColorInConsole;

import java.util.Locale;
import java.util.Scanner;

public class FuramaController {
    private final Scanner scanner = new Scanner(System.in);
    CustomerController customerController = new CustomerController();
    EmployeeController employeeController = new EmployeeController();
    FacilityController facilityController = new FacilityController();
    BookingController bookingController = new BookingController();
    PromotionController promotionController = new PromotionController();

    public void showMenuFurama() {
        do {
            System.out.println(
                    ColorInConsole.ANSI_GREEN
                            + "\n---------------------------------------------------"
                            + ColorInConsole.ANSI_BLUE
            );
            System.out.println(
                    "|             ----- QUẢN LÝ FURAMA -----           |"
                            + ColorInConsole.ANSI_BLUE
            );

            System.out.println("|               1.Quản lý nhân viên                |\n" +
                    "|               2.Quản lý khách hàng               |\n" +
                    "|               3.Quản lý cơ sở                    |\n" +
                    "|               4.Quản lý Booking                  |\n" +
                    "|               5.Quản lý khuyến mãi               |\n" +
                    "|               6.Exit                             |");
            System.out.println(ColorInConsole.ANSI_GREEN +
                    "\n---------------------------------------------------"
                    + ColorInConsole.ANSI_BLUE
            );
            System.out.print("Chọn chức năng: ");
            String select = scanner.nextLine();
            switch (select) {
                case "1":
                    employeeController.showMenuEmployee();
                    break;
                case "2":
                    customerController.showMenuCustomer();
                    break;
                case "3":
                    facilityController.showMenuFacility();
                    break;
                case "4":
                    bookingController.showMenuBooking();
                    break;
                case "5":
                    promotionController.showMenuPromotion();
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
