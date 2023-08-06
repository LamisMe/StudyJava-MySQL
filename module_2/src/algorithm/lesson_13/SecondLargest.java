package algorithm.lesson_13;


import java.util.ArrayList;
import java.util.List;

public class SecondLargest {
    public static int checkSecondLargest(String str) {
        String[] arr = str.split(",");
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            integerList.add(Integer.valueOf(arr[i]));
        }
        int max = integerList.get(0);
        for (int i = 0; i < integerList.size(); i++) {
            if (max < integerList.get(i)) {
                max = integerList.get(i);
            }
        }
        int second = 0;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (second < Integer.parseInt(arr[i])) {
                second = Integer.parseInt(arr[i]);
                if(second<max){
                    index = i;
                }else {
                    second = 0;
                }
            }
        }
        return index;
    }
}
