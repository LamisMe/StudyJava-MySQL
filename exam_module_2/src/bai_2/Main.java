package bai_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        do {
            System.out.println("Nhập độ dài của mảng (Không vượt quá 200 phần tử)");
            size = Integer.parseInt(scanner.nextLine());
        } while (size > 200 || size < 1);

        int[] arrayInt = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Nhập giá trị cho phần tử thứ " + i);
            arrayInt[i] = Integer.parseInt(scanner.nextLine());
        }

        boolean flag = SoNguyen.tanSuatXuatHien(arrayInt);
        if (!flag) {
            System.out.println("Tần số xuất hiện của tất cả các số nguyên trong mảng không bằng nhau");
        } else {
            System.out.println("Tần suất xuất hiện bằng nhau");
        }
    }
}
