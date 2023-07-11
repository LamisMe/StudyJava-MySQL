package ss6_inheritance.bai_1;

public class Circle {
    public final double PI = 3.14;
    private double radios;
    private String color;

    public Circle() {
    }

    public Circle(double radios, String color) {
        this.radios = radios;
        this.color = color;
    }

    public double getRadios() {
        return radios;
    }

    public void setRadios(double radios) {
        this.radios = radios;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double area() {
        return this.radios * this.radios * PI;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radios=" + radios +
                ", color='" + color + '\'' +
                '}';
    }
}
