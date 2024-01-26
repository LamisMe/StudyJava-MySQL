package controller.sub_classes_mandates;

import service.facility.IFacilityService;
import service.facility.classes.FacilityService;
import utils.ColorInConsole;

import java.util.Scanner;

public class FacilityController {
    private final Scanner scanner = new Scanner(System.in);
    private final IFacilityService facilityService = new FacilityService();

    public void showMenuFacility() {
        do {
            System.out.println(
                    ColorInConsole.ANSI_GREEN
                            + "\n---------------------------------------------------"
                            + ColorInConsole.ANSI_BLUE
            );
            System.out.println(
                    "|             ----- Quản lý Cơ Sở -----           |"
                            + ColorInConsole.ANSI_BLUE
            );

            System.out.println("|            1.Hiển thị danh sách cơ sở           |\n" +
                    "|            2.Thêm mới cơ sở                     |\n" +
                    "|            3.Hiển thị danh sách bảo trì cơ sở   |\n" +
                    "|            4.Xóa cơ sở                          |\n" +
                    "|            5.Quay lại trang trước               |");
            System.out.println(ColorInConsole.ANSI_GREEN +
                    "\n---------------------------------------------------"
                    + ColorInConsole.ANSI_BLUE
            );
            System.out.print(  "Chọn chức năng: ");
            String select = scanner.nextLine();
            switch (select) {
                case "1":
                    facilityService.display();
                    break;
                case "2":
                    facilityService.add();
                    break;
                case "3":
                    System.out.println("Danh sách cơ sở cần phải bảo trì ");
                    facilityService.displayAllMaintenance();
                    break;
                case "4":
                    facilityService.remove();
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Nhập sai nhập lại");
                    break;
            }
        } while (true);
    }
}
