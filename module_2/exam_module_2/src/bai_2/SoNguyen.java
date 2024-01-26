package bai_2;

import java.util.LinkedHashMap;
import java.util.Map;

public class SoNguyen {
    public static boolean tanSuatXuatHien(int[] arrayInt) {
        Map<Integer, Integer> integerMap = new LinkedHashMap<>();
        for (int i = 0; i < arrayInt.length; i++) {
            if (!integerMap.containsKey(arrayInt[i])) {
                integerMap.put(arrayInt[i], 1);
            } else {
                integerMap.put(arrayInt[i], integerMap.get(arrayInt[i]) + 1);
            }
        }
        int temp = integerMap.get(arrayInt[0]);

        for (Map.Entry<Integer, Integer> entry : integerMap.entrySet()) {
            System.out.println("Số "+entry.getKey()+" xuất hiện "+entry.getValue()+" lần");
            if (entry.getValue() != temp) {
                return false;
            }
        }

        return true;
    }
}
