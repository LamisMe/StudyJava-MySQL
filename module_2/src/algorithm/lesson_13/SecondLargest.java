package algorithm.lesson_13;

import java.util.Arrays;

public class SecondLargest {
    public static int findSecondLargest(String str){
        String[] arr = str.split(",");
        int[] arrInt = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrInt[i] = Integer.parseInt(arr[i]);
        }
        int max = arrInt[0];

        return max;
    }
}
