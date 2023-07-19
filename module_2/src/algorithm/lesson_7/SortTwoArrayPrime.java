package algorithm.lesson_7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTwoArrayPrime {
    public static boolean checkPrime(int number){
        if(number<2){
            return false;
        }else {
            for (int i = 2; i < number; i++) {
                if (number%i==0){
                    return false;
                }
            }
        }
        return true;
    }
    public static int[] sortArrayPrime(int[][] arr){
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(checkPrime(arr[i][j])&& !integerList.contains(arr[i][j])){
                    integerList.add(arr[i][j]);
                }
            }
        }
        Collections.sort(integerList);
        int[] newArr = new int[integerList.size()];
        for (int i = 0; i < newArr.length ; i++) {
            newArr[i] = integerList.get(i);
        }
        return newArr;
    }
}
