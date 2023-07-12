package ss7_abstract_class_and_interface.interface_resizeable;

public class Rectangle implements Resizeable {
    private double length;
    private double width;

    public Rectangle() {
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
    /**
     *
     * @return kết quả của diện tích hình chữ nhật
     * @creator: Lam
     */
    public double getArea() {
        return (this.length * this.width);
    }
    /**
     * resize là kích thước phần tăng lên
     * @param percent phần trăm mà người dùng nhập vào
     * @creator: Lam
     */
    @Override
    public void resize(double percent) {
       setLength(getLength()+getLength()*(percent/100));
       setWidth(getWidth()+getWidth()*(percent/100));
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "length= " + length +
                ", width= " + width +
                ", area= " + getArea() +
                '}';
    }
}
