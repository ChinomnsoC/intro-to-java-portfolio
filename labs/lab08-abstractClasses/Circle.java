public class Circle extends Shape {
    double radius;
    public Circle(double radius){
        this.radius = radius;
    }
    public double area(){
        return (radius * radius) * 3.14;
    }
    public double perimeter() {
        return 2 * 3.14 * radius;
    }

    public String toString(){
        return String.format("This Circle has a circumference of %.2f and an area of %.2f", perimeter(), area());
    }
}