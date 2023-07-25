package controller;

import javafx.scene.transform.Scale;

import java.util.Scanner;

public class FuramaController {
    private final Scanner scanner = new Scanner(System.in);
    public void showMenuFurama(){
        System.out.println("-----------Quản lý Furama------------");
        System.out.println("1.Quản lý khách hàng");
        System.out.println("2.Quản lý nhân viên");
        System.out.println("3.Quản lý cơ sở");
        System.out.println("4.Quản lý Booking");
        System.out.println("5.Quản lý khuyến mãi");
        System.out.println("6.Exit");
        String select = scanner.nextLine();
        switch (select){
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
    }
}
