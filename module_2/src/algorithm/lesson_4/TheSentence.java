package algorithm.lesson_4;


public class TheSentence {
    public static String amendTheSentence(String str){
        StringBuilder arr = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if(Character.isUpperCase(str.charAt(i))){
                arr.append(" ").append(str.toLowerCase().charAt(i));
            } else {
                arr.append(str.charAt(i));
            }
        }
        return  arr.toString().trim();
    }
}
