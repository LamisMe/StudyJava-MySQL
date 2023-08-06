package al;

public class MyClass{

    public static void main(String[] args){

        System.out.print("A");
        System.out.println(m(1,2,3));

    }

    static int m(int...x) {
        int b = 0;
        for(int a:x){
            b+=a;
        }
        return b;
    }

}