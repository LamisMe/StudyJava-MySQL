package ss6_inheritance.bai_2;

public class Main {
    public static void main(String[] args) {
        Point2D point2D = new Point2D(2,3);
        Point3D point3D = new Point3D(2,3,4);
        point3D.setXYZ(3,5,7);
        point2D.setXY(3,4);
        System.out.println(point2D);
        System.out.println(point3D);
    }
}
