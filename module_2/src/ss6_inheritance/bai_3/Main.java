package ss6_inheritance.bai_3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MovablePoint movablePoint = new MovablePoint(3, 6, 8, 9);
        Point point = new Point(7, 6);
        System.out.println(movablePoint);
        System.out.println(Arrays.toString(movablePoint.getXY()));
        System.out.println(Arrays.toString(point.getXY()));
        System.out.println(movablePoint.move());
        System.out.println(Arrays.toString(movablePoint.getSpeed()));
    }
}
