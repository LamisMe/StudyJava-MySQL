package ss17_io_binary_file.copy_file;

import ss17_io_binary_file.mvc.common.ReadToFileBinary;
import ss17_io_binary_file.mvc.common.WriteToFileBinary;
import ss17_io_binary_file.mvc.model.Product;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập đường dẫn đến tập tin nguồn: ");
        String linkSource = scanner.nextLine();
        System.out.println("Nhập thông tin gì đó cho tập tin nguồn");
        String line = scanner.nextLine();
        ReadWriteToFileBinary.writeFileBinary(linkSource,line,false);
        System.out.print("Nhập đường dẫn đến tập tin đích: ");
        String linkTarget = scanner.nextLine();
        String stringList = ReadWriteToFileBinary.readFileBinary(linkSource);
        ReadWriteToFileBinary.writeFileBinary(linkTarget, stringList, false);
        String strings = ReadWriteToFileBinary.readFileBinary(linkTarget);
        System.out.println("COPY COMPLETE");
    }
}
