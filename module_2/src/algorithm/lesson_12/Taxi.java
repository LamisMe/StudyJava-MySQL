package algorithm.lesson_12;

import java.util.ArrayList;
import java.util.List;

public class Taxi {
    public static int bookTaxi(String str) {
        String[] arr = str.split(",");
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            integerList.add(Integer.valueOf(arr[i]));
        }
        int size = 4;
        int count = 0;
        for (int i = 0; i < integerList.size(); i++) {
            if (integerList.get(i) < size) {
                for (int j = 0; j < i; j++) {
                    if (integerList.get(j) < size) {
                        if (integerList.get(j) + integerList.get(i) <= size) {
                            count++;
                            break;
                        }
                    } else {
                        count++;
                        break;
                    }
                }
            }else {
                count++;
            }
        }
        return count;
    }
}
