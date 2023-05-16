package Exercises_on_Polymorphism_Abstract_Classes_and_Interfaces.ex6_1;

public class Circle extends Shape {
    protected double radius;
    public Circle(){
        this(1.0);
    }

    public Circle(double radius){
        this.radius = radius;

    }
    public Circle(double radius, String color, boolean filled) {
        this.radius = radius;
    }
    public double getRadius(){
        return this.radius;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    @Override
    public double getArea(){
        return Math.pow(this.radius,2) * Math.PI;
    }
    @Override
    public double getPerimeter(){
        return 2 * Math.PI * getRadius();
    }
    @Override
    public String toString(){
        return "Circle[" + super.toString() + "],radius="+ getRadius() + "]";
    }

}
