package bai_3.controller;

import bai_3.service.EmployeeService;
import bai_3.service.IEmployeeService;

import java.util.Scanner;

public class EmployeeController {
    private final IEmployeeService employeeService = new EmployeeService();
    private final Scanner scanner = new Scanner(System.in);
    public void showMenuEmployee(){
        do {
            System.out.println("-------Quản lý nhân viên--------- ");
            System.out.println("1.Hiển thị danh sách nhân viên");
            System.out.println("2.Thêm mới nhân viên");
            System.out.println("3.Tính tiên thưởng cuối năm ");
            System.out.println("0.Thoát");
            String select = scanner.nextLine();
            switch (select){
                case "1":
                    employeeService.display();
                    break;
                case "2":
                    employeeService.add();
                    System.out.println("Thêm mới thành công");
                    break;
                case "3":
                    employeeService.bonusEndYear();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Nhập sai nhập lại");
                    break;
            }
        }while (true);
    }
}
