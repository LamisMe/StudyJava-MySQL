package algorithm.lesson_11;


import java.util.Comparator;

public class ThayGiaoBa  {
     public static int muaBut(int x, int y, int z) {
        int result = 0;
        int by = x + y;
        int num = 1;
        int one = x;
        int two = y;
        while (z >= result) {
            x = one;
            y = two;
            x = x * num;
            y = y * num;
            for (int i = 0; i < by; i++) {
                if (x + y + i >= z) {
                    result = x + i;
                    return result;
                }
            }
            num++;
        }
        return -1;
    }

}
