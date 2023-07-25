package algorithm.lesson_10;

public class Money {
    public static int exchangeMoney(int[] arr, int n) {
        int maxMoney = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (n - arr[j] + arr[i] > maxMoney && arr[i] != 0 && arr[j] != 0) {
                    maxMoney = n - arr[j] + arr[i];
                }
            }
        }
        if (maxMoney < n) {
            return n;
        }
        return maxMoney;
    }
}
