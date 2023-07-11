package ss6_inheritance.bai_1;

public class Cylinder extends Circle {
    private double height;

    public Cylinder() {
    }

    public Cylinder(double radios, String color, double height) {
        super(radios, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }


    public double area() {
        return super.area() * 2 + (2 * PI * getRadios() * height);
    }

    public double volume() {
        return PI * (getRadios() * getRadios()) * height;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "radios=" + getRadios() +
                ", color='" + getColor() + '\'' +
                "height=" + height +
                '}';
    }
}
