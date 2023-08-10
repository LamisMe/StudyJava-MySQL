package bai_1;

import java.util.ArrayList;
import java.util.List;

public class SoNguyenTo {
    public static boolean kiemTraSoNguyenTo(int number) {
        if (number < 2) {
            return false;
        } else {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int timSoNguyenToLonNhat(int[] arrayInt) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < arrayInt.length; i++) {
            if (kiemTraSoNguyenTo(arrayInt[i])) {
                integerList.add(arrayInt[i]);
            }
        }
        if (integerList.isEmpty()) {
            return -1;
        }
        int max = integerList.get(0);
        for (int i = 1; i < integerList.size(); i++) {
            if (max < integerList.get(i)) {
                max = integerList.get(i);
            }

        }
        return max;
    }
}
