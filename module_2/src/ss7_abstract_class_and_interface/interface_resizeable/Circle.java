package ss7_abstract_class_and_interface.interface_resizeable;

public class Circle implements Resizeable {
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     *
     * @return kết quả của diện tích hình tròn
     */
    public double getArea() {
        return (this.radius * this.radius) * 3.14;
    }


    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "Area: " + getArea()+
                ", radius:" +

                 getRadius()+
                "}";
    }

    /**
     * resize là kích thước phần tăng lên
     * @param percent phần trăm mà người dùng nhập vào
     * @creator: Lam
     */
    @Override
    public void resize(double percent) {
        setRadius(getRadius()+getRadius()*(percent / 100));
    }
}
