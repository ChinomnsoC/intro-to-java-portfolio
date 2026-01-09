public abstract class Shape {
    public abstract String toString(); 
    //We expect every implementation of this method to provide a string that mentions the name of the shape, the perimeter, and the area
    public abstract double area();
    //We expect every implementation of this method to return the area
    public abstract double perimeter();
    //We expect every implmentation of this method to return the perimeter/circumference
}