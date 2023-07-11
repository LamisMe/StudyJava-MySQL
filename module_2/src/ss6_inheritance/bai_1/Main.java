package ss6_inheritance.bai_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập bán kính hình tròn");
        double radios = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập màu sắc của hình tròn");
        String color = scanner.nextLine();
        System.out.println("Nhập chiều cao của hình trụ");
        double height = Double.parseDouble(scanner.nextLine());
        Circle circle = new Circle(radios,color);
        Cylinder cylinder = new Cylinder(radios,color,height);
        System.out.println(circle);
        System.out.println("Diện tích của hình tròn");
        System.out.println(circle.area());
        System.out.println("Diện tích của hình trụ");
        System.out.println(cylinder.area());
        System.out.println("Thể tích của hình trụ");
        System.out.println(cylinder.volume());
    }
}
