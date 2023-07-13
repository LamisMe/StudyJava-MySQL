package ss8_clean_code.mvc.common;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteToFile {
    public static void writeToFile(String path, List<String> stringList, boolean append){
        try {
            FileWriter fileWriter = new FileWriter(path, append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String s : stringList) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        }catch (FileNotFoundException e){
            System.out.println("File Not Found");
        } catch (IOException e) {
            System.out.println("IOException");;
        }
    }

    public static List<String> readToFile(String path){
        List<String> stringList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while((line= bufferedReader.readLine())!=null){
                stringList.add(line);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e) {
            System.out.println("IOException");;
        }
        return stringList;
    }
}
