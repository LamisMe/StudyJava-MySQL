package algorithm.lesson_3;

public class BeautifulArray {
    public static boolean checkBeautifulArray(String arr){
        String[] str = arr.split(",");
        for (int i = 1; i < str.length; i++) {
            int sum1 = 0;
            int sum2 = 0;
            for (int j = 0; j < i ; j++) {
                sum1 += Integer.parseInt(str[j]);
            }
            for (int j = i+1; j < str.length; j++) {
                sum2+= Integer.parseInt(str[j]);
            }
            if (sum1==sum2){
                return true;
            }
        }
        return false;
    }
}
