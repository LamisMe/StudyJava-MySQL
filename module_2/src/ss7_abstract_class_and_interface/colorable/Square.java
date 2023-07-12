package ss7_abstract_class_and_interface.colorable;

public class Square extends Shape implements Colorable{
    private int edge;

    public Square() {
    }

    public Square(int edge) {
        this.edge = edge;
    }

    public Square(String color, boolean filled, int edge) {
        super(color, filled);
        this.edge = edge;
    }

    public int getEdge() {
        return edge;
    }

    public void setEdge(int edge) {
        this.edge = edge;
    }

    /**
     *
     * @return kết quả của diện tích hình vuông
     * @creator: Lam
     */
    public double getArea() {
        return (this.edge * this.edge);
    }
    /**
     * @creator: Lam
     */
    @Override
    public void howToColor() {
        System.out.println("Color all four sides..");
    }

    @Override
    public String toString() {
        return super.toString()+ "Square{" +
                "edge=" + edge +
                ", area=" + getArea() +
                '}';
    }
}
