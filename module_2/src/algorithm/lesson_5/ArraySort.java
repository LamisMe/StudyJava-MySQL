package algorithm.lesson_5;

public class ArraySort {
    public static int[] sortByHeight(int[] arrInt){
        for (int i = 1; i < arrInt.length; i++) {
            for (int j = 0; j <i ; j++) {
                if(arrInt[i]<arrInt[j] && arrInt[i]!=-1){
                    int temp = arrInt[i];
                    arrInt[i] = arrInt[j];
                    arrInt[j] = temp;
                }
            }
        }
        return arrInt;
    }
}
