package algorithm.lesson_9;

import java.util.ArrayList;
import java.util.List;

public class Circle {
    public static boolean numCircle(int n) {
        String a = String.valueOf(n);
        if(a.charAt(0)==a.charAt(a.length()-1)){
            return true;
        }
        return false;
    }
    public static int numCircle(int l, int r) {
        int count = 0;
        for (int i = l; i < r; i++) {
            if(numCircle(l)){
                count++;
            }
        }
        return count;
    }
}
