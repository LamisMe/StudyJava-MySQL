package controller.sub_classes_person;

import service.person.IPersonService;
import service.person.classes.CustomerService;
import utils.ColorInConsole;

import java.util.Scanner;

public class CustomerController {
    private final Scanner scanner = new Scanner(System.in);
    private final IPersonService personService = new CustomerService();
    public void showMenuCustomer() {
        do {
            System.out.println(
                    ColorInConsole.ANSI_GREEN
                            + "\n---------------------------------------------------"
                            + ColorInConsole.ANSI_BLUE
            );
            System.out.println(
                    "|             ----- Quản lý Khách Hàng -----       |"
                            + ColorInConsole.ANSI_BLUE
            );

            System.out.println("|              1.Hiển thị danh sách khách hàng     |\n" +
                    "|              2.Thêm mới khách hàng               |\n" +
                    "|              3.Chỉnh sửa thông tin khách hàng    |\n" +
                    "|              4.Xóa khách hàng                    |\n" +
                    "|              5.Tìm kiếm theo tên khách hàng      |\n" +
                    "|              6.Quay lại trang trước              |");

            System.out.println(ColorInConsole.ANSI_BLUE +
                    "\n---------------------------------------------------"
                    + ColorInConsole.ANSI_BLUE
            );
            System.out.print("Chọn chức năng: ");
            String select = scanner.nextLine();
            switch (select) {
                case "1":
                    personService.read();
                    break;
                case "2":
                    personService.create();
                    System.out.println("Thêm thành công!!!!!");
                    break;
                case "3":
                    personService.update();
                    System.out.println("Cập nhật thông tin thành công");
                    break;
                case "4":
                    personService.delete();
                    break;
                case "5":
                    personService.searchByName();
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
