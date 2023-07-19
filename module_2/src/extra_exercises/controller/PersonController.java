package extra_exercises.controller;

import extra_exercises.service.*;

import java.util.Scanner;

public class PersonController {
    private final IPersonService foreignerPeopleService = new ForeignerPeopleService();
    private final IPersonService vietNamPeopleService = new VietNamPeopleService();
    private final IBillService billService = new BillService();
    private final Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        do {
            System.out.println(" CHƯƠNG TRÌNH QUẢN LÝ HÓA ĐƠN TIỀN ĐIỆN\n" +
                    "Chọn chức năng:\n" +
                    "1. Thêm mới khách hàng.\n" +
                    "2. Hiển thị thông tin khách hàng\n" +
                    "3. Tìm kiếm khách hàng\n" +
                    "4. Thêm mới hóa đơn\n" +
                    "5. Chỉnh sửa hóa đơn\n" +
                    "6. Hiển thị thông  tin chi tiết hóa đơn\n" +
                    "0.Thoát");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("1. Thêm khách hàng Việt Nam\n" +
                            "2. Thêm khách hàng nước ngoài");
                    String select = scanner.nextLine();
                    if(select.equals("1")){
                        vietNamPeopleService.create();
                    }else if(select.equals("2")){
                        foreignerPeopleService.create();
                    }else {
                        System.out.println("Bạn đã nhập sai");
                    }
                    break;
                case "2":
                    System.out.println("-------------HIỂN THỊ--------------");
                    System.out.println("1. Hiển thị danh sách khách hàng Việt Nam\n" +
                            "2. Hiển thị danh sách khách hàng nước ngoài");
                    String select1 = scanner.nextLine();
                    if(select1.equals("1")){
                        vietNamPeopleService.read();
                    }else if (select1.equals("2")){
                        foreignerPeopleService.read();
                    }else {
                        System.out.println("Bạn đã nhập sai");
                    }
                    break;
                case "3":
                    System.out.println("-------------Tìm Kiếm--------------");
                    System.out.println("1. Tìm kiếm khách hàng Việt Nam\n" +
                            "2. Tìm kiếm khách hàng nước ngoài");
                    String select2 = scanner.nextLine();
                    if(select2.equals("1")){
                        vietNamPeopleService.search();
                    }else if (select2.equals("2")){
                        foreignerPeopleService.search();
                    }else {
                        System.out.println("Bạn đã nhập sai");
                    }
                    break;
                case "4":
                    billService.add();
                    break;
                case "5":
                    billService.update();
                    break;
                case "6":
                    billService.display();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Vui lòng nhập đúng");
                    break;
            }
        } while (true);
    }
}
