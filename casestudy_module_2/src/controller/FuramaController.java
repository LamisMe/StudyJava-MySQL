package controller;

import controller.sub_classes_mandates.BookingController;
import controller.sub_classes_mandates.FacilityController;
import controller.sub_classes_mandates.PromotionController;
import controller.sub_classes_person.CustomerController;
import controller.sub_classes_person.EmployeeController;

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
            System.out.println();
            System.out.println("-----------Quản lý Furama------------");
            System.out.println("1.Quản lý nhân viên");
            System.out.println("2.Quản lý khách hàng");
            System.out.println("3.Quản lý cơ sở");
            System.out.println("4.Quản lý Booking");
            System.out.println("5.Quản lý khuyến mãi");
            System.out.println("6.Exit");
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
        }while (true);
    }
}
