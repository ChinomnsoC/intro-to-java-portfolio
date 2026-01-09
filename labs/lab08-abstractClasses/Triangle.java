
//This is the class that you will be finishing. You need to implement the area(), perimeter(), and toString()
/*
What would happen if we added a new class that extended Shape and did not implement its methods? A compilation error. Polymorphism 
requires that all the methods of an abstract class are implemented by a class that extends said abstract class. Abstract methods
promise functionality without saying how, so when a class implements it without all the methods, the object will be incomplete.

Notice that the use of @Override appears to be unnecessary for Circle and Rectangle, even though they are technically 
overriding area(), perimeter(), and toString(). Why do you think this is?
The code runs the same.

Notice that your IDE (Eclipse or Intellij) already seems to have some issues with the Triangle class. 
Write your best interpretation of these errors.
Since Triangle extends Shape, it is required to implement all the methods in Shape.

What is the value of using abstract classes instead of always having a default that other classes inherit from?
Customisation, i think? It is also good for ensuring consistency. The abstract methods can be sort of a template, and then
When other classes extend them, they'll follow a certain pattern.
 */

public class Triangle extends Shape {
    double length;
    double width;
    double third;

    public Triangle(double length, double width, double third) {
        this.length = length;
        this.width = width;
        this.third = third;
    }

    public double area() {
        return (length * width) / 2;
    }

    public double perimeter() {
        return (length + width + third);
    }

    public String toString() {
        return String.format("This Triangle has a perimeter of %.2f and an area of %.2f", perimeter(), area());
    }

    public static void main(String[] args) {
        Triangle myTriangle = new Triangle(1.4, 3.5, 3.77);
        System.out.println("TESTING: " + myTriangle.toString());
        System.out.println("TESTING: " + myTriangle.area());
        System.out.println("TESTING: " + myTriangle.perimeter());
    }
}