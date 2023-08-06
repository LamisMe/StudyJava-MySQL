package algorithm.lesson_20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LengthDataArray {
    public static String[] sortByLength(String[] arr) {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            stringList.add(arr[i]);
        }
        Collections.sort(stringList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        String[] sort = new String[arr.length];
        for (int i = 0; i < stringList.size(); i++) {
            sort[i] = stringList.get(i);
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].length() > arr[j].length()) {
                    String temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
