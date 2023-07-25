package ss17_io_binary_file.copy_file;

import ss17_io_binary_file.mvc.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteToFileBinary {
    public static String readFileBinary(String path){
        String stringList = "";
        try{
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            stringList +=  objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFound");
        } catch (IOException e) {
            System.out.println("IOE");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFound");
        }
        return stringList;
    }
    public static void writeFileBinary(String path, String text,boolean append){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(path,append);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(text);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFound");
        } catch (IOException e) {
            System.out.println("IOE");
        }
    }
}
