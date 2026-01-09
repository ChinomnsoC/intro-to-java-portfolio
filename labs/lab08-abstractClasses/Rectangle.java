public class Rectangle extends Shape {
    double length;
    double width;
    public Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }

    public double area() {
        return length * width;
    }

    public double perimeter() {
        return length * width;
    }
    public String toString(){
        return String.format("This Rectangle has a perimeter of %.2f and an area of %.2f", perimeter(), area());
    }
}