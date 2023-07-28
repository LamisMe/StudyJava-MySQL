package controller.sub_classes_person;

import service.person.IPersonService;
import service.person.classes.EmployeeService;
import utils.ColorInConsole;

import java.util.Scanner;

public class EmployeeController {
    private final Scanner scanner = new Scanner(System.in);
    private final IPersonService personService = new EmployeeService();

    public void showMenuEmployee() {
        do {
            System.out.println(
                    ColorInConsole.ANSI_GREEN
                            + "\n---------------------------------------------------"
                            + ColorInConsole.ANSI_BLUE
            );
            System.out.println(
                    "|             ----- Quản lý Nhân Viên -----       |"
                            + ColorInConsole.ANSI_BLUE
            );

            System.out.println("|             1.Hiển thị danh sách nhân viên      |\n" +
                    "|             2.Thêm mới nhân viên                |\n" +
                    "|             3.Chỉnh sửa thông tin nhân viên     |\n" +
                    "|             4.Xóa nhân viên                     |\n" +
                    "|             5.Tìm kiếm theo tên nhân viên       |\n" +
                    "|             6.Quay lại trang trước              |" );
            System.out.println(ColorInConsole.ANSI_YELLOW +
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
