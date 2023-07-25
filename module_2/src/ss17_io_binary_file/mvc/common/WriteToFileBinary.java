package ss17_io_binary_file.mvc.common;

import ss17_io_binary_file.mvc.model.Product;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class WriteToFileBinary {
    public static void writeFileBinary(String path, List<Product> productList,boolean append){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(path,append);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(productList);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFound");
        } catch (IOException e) {
            System.out.println("IOE");
        }
    }
}
