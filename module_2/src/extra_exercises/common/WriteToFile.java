package extra_exercises.common;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteToFile
{
    public static void writeToFile(String path, List<String> stringList,boolean append){
        try {
            FileWriter fileWriter = new FileWriter(path,append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String str:stringList) {
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        }catch (FileNotFoundException e){
            System.out.println("FileNotFound");
        }
        catch (IOException e) {
            System.out.println("IOException");
        }
    }
}
