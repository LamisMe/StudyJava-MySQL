package algorithm.lesson_8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChildOfParent {
    public static int countChildOfParent(String str1,String str2){
        String[] arr1 = str1.split(",");
        String[] arr2 = str2.split(",");
        List<Integer> integerList1 = new ArrayList<>();
        List<Integer> integerList2 = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            integerList1.add(Integer.parseInt(arr1[i]));
        }
        for (int i = 0; i < arr2.length; i++) {
            integerList2.add(Integer.parseInt(arr2[i]));
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < integerList1.size(); i++) {
            for (int j = 0; j < integerList2.size() ; j++) {
                if(integerList2.get(j) == integerList1.get(i)){
                    list.add(integerList2.get(j));
                }
            }
        }
        for (int i = 0; i < integerList2.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if(!list.contains(integerList2.get(i))){
                    return 0;
                }
            }
        }
            Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            if(!map.keySet().contains(list.get(i))) {
                map.put(list.get(i), 1);
            }else {
                map.put(list.get(i),map.get(list.get(i))+1);
            }
        }
         int min = map.get(list.get(0));
        for (Map.Entry<Integer,Integer> key: map.entrySet()) {
            if(key.getValue()<min){
                min = key.getValue();
            }
        }
        return min;
    }
}
