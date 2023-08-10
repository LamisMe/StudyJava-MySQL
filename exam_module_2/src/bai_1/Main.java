package bai_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        do {
            System.out.println("Nhập độ dài của mảng (Không vượt quá 100 phần tử)");
            size = Integer.parseInt(scanner.nextLine());
        } while (size > 100 || size < 1);

        int[] arrayInt = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Nhập giá trị cho phần tử thứ " + i);
            arrayInt[i] = Integer.parseInt(scanner.nextLine());
        }

        int result = SoNguyenTo.timSoNguyenToLonNhat(arrayInt);
        if (result == -1) {
            System.out.println("Không có số nguyên tố trong mảng, kết quả: " + result);
        } else {
            System.out.println("Số nguyên tố lớn nhất là: " + result);
        }
    }
}
