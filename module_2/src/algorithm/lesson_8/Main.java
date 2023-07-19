package algorithm.lesson_8;

public class Main {
    public static void main(String[] args) {
        String str1 = "1,4,5,2,3";
        String str2 = "1,2,3";
        if(ChildOfParent.countChildOfParent(str1,str2)>0){
            System.out.println("Xuất hiện "+ChildOfParent.countChildOfParent(str1,str2)+ " lần");
        }else {
            System.out.println("Không xuất hiện");
        }
    }
}
