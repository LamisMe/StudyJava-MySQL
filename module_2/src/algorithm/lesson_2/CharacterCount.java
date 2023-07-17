package algorithm.lesson_2;

import java.util.ArrayList;
import java.util.List;

public class CharacterCount {
    public static int commonCharacterCount(String char1,String char2){
        List<Character> characterList = new ArrayList<>();
        List<Character> characterList1 = new ArrayList<>();
        List<Character> characterList2 = new ArrayList<>();
        for (int i = 0; i < char1.length(); i++) {
            characterList1.add(char1.charAt(i));
        }
        for (int i = 0; i < char2.length(); i++) {
            characterList2.add(char2.charAt(i));
        }
        for (int i = 0; i < characterList1.size(); i++) {
            for (int j = 0; j < characterList2.size(); j++) {
                if(characterList1.get(i).equals(characterList2.get(j))){
                    characterList.add(characterList2.get(j));
                    characterList1.remove(characterList1.get(i));
                }
            }
        }
        return characterList.size();
    }
}
