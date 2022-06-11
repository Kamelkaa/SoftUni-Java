package lab.shapes;

public abstract class Shape {
    private Double perimeter;
    private Double area;

    protected abstract double calculatePerimeter();

    protected abstract double calculateArea();

    protected Double getPerimeter() {
        return perimeter;
    }

    protected Double getArea() {
        return area;
    }
}
