package Exercises_on_Polymorphism_Abstract_Classes_and_Interfaces.ex6_5;

public class Circle implements GeometricObject{
    protected double radius;
    public Circle(double radius){
        this.radius = radius;
    }
    public String toString(){
        return "Circle[radius=" + this.radius + "]";
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius,2);
    }
}
