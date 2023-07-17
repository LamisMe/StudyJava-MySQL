package algorithm.lesson_1;

import java.util.HashMap;
import java.util.Map;

public class EqualFrequency {
    public static boolean checkEqualFrequency(int[] arrInt) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < arrInt.length; i++) {
            if (!map.containsKey(arrInt[i])) {
                map.put(arrInt[i], 1);
            }else {
                map.put(arrInt[i], map.get(arrInt[i])+1);
            }
        }
        int value = map.get(arrInt[0]);
        for (Map.Entry<Integer,Integer> mapEntry:map.entrySet()) {
            if(!mapEntry.getValue().equals(value)){
                return false;
            }
        }
        if(map.size()<2){
            return false;
        }else {
            return true;
        }
    }
}
