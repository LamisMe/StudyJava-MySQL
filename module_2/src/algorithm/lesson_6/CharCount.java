package algorithm.lesson_6;

import java.util.ArrayList;
import java.util.List;

public class CharCount {
    public static String[] findChar(String str){
        String[] arr = str.split("");
        List<String> stringList = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[j].equals(arr[i]) && !stringList.contains(arr[j])){
                    stringList.add(arr[j]);
                }
            }
        }
        String[] newArr = new String[stringList.size()];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = stringList.get(i);
        }
        return newArr;
    }
}
