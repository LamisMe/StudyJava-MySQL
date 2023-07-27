package controller.sub_classes_mandates;

import java.util.Scanner;

public class PromotionController {
    private final Scanner scanner = new Scanner(System.in);
    public void showMenuPromotion(){
        do {
            System.out.println();
            System.out.println("-------------Quản lý Khuyến Mãi-----------");
            System.out.println("1.Hiển thị danh sách khách hàng sử dụng dịch vụ");
            System.out.println("2.Hiển thị danh sách khách hàng nhận voucher");
            System.out.println("3.Quay lại trang trước");
            System.out.print("Chọn chức năng: ");
            String select = scanner.nextLine();
            switch (select) {
                case "1":
                case "2":
                case "3":
                    return;
                default:
                    System.out.println("Nhập sai nhập lại");
                    break;
            }
        }while(true);
    }
}
