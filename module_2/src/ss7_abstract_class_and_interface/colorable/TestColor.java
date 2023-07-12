package ss7_abstract_class_and_interface.colorable;

public class TestColor {
    public static void main(String[] args) {
        Shape[] shape = new Shape[3];
        shape[0] = new Circle(5,"White",true);
        shape[1] = new Square("Red",true,7);
        shape[2] = new Circle(3,"Blue",true);
        for (Shape a: shape){
            if(a instanceof Colorable){
                 ((Colorable) a).howToColor();
            }else {
                System.out.println(a.toString());
            }
        }
    }
}
