package lab.shapes;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(2.0);
        Shape rectangle = new Rectangle(4.0, 3.0);

        System.out.println(circle.calculatePerimeter());
        System.out.println(circle.calculateArea());
        System.out.println(rectangle.calculatePerimeter());
        System.out.println(rectangle.calculateArea());
    }
}
