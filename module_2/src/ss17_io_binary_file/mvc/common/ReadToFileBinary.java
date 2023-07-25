package ss17_io_binary_file.mvc.common;

import ss17_io_binary_file.mvc.model.Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadToFileBinary {
    public static List<Product> readFileBinary(String path){
        List<Product> productList = new ArrayList<>();
        try{
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            productList = (List<Product>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFound");
        } catch (IOException e) {
            System.out.println("IOE");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFound");
        }
        return productList;
    }
}
