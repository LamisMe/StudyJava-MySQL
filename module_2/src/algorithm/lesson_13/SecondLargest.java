package algorithm.lesson_13;

import java.util.Arrays;

public class SecondLargest {
    public static int findFirstLargest(String str){
        String[] arr = str.split(",");
        int[] arrInt = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrInt[i] = Integer.parseInt(arr[i]);
        }
        int max = arrInt[0];
        for (int i = 0; i < arrInt.length; i++) {
            if(max <arrInt[i]){
                max = arrInt[i];
            }
        }
        return max;
    }
//    public static int findSecondLargest(int max){
//
//    }
}
