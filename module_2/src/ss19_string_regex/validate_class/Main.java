package ss19_string_regex.validate_class;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên của lớp\n" +
                "Bắt đầu bằng một ký tự chữ hoa C hoặc A hoặc P\n" +
                "\n" +
                "Không chứa các ký tự đặc biệt\n" +
                "\n" +
                "Theo sau ký tự bắt đầu là 4 ký tự số \n" +
                "\n" +
                "Kết thúc phải là 1 trong những ký tự chữ hoa sau: G, H, I, K");
        String line = scanner.nextLine();
        if(!ClassesName.validateNameClasses(line)){
            System.out.println("Bạn đã nhập sai định dạng");
        }else {
            System.out.println("Bạn đã nhập đúng định dạng");
        }
    }
}
