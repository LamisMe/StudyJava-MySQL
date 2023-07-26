package ss19_string_regex.validate_phone_number;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số điện thoại \n" +
                "Số điện thoại hợp lệ cần đạt theo mẫu sau: (xx)-(0xxxxxxxxx)\n" +
                "+ x là ký tự số\n" +
                "+ Không chứa các ký tự đặc biệt");
        String phoneNumber = scanner.nextLine();
        if (!PhoneNumber.validateNameClasses(phoneNumber)) {
            System.out.println("Bạn đã nhập sai định dạng");
        } else {
            System.out.println("Bạn đã nhập đúng định dạng");
        }
    }
}
