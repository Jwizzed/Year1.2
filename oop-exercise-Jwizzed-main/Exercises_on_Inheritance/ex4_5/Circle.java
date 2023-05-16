package Exercises_on_Inheritance.ex4_5;

public class Circle extends Shape {
    private double radius;
    public Circle(){
        radius = 1.0;
    }
    public Circle(double radius){

    }
    public Circle(double radius, String color, boolean filled){
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getArea(){
        return this.radius * Math.PI * this.radius;
    }
    public double getPerimeter(){
        return this.radius * 2* Math.PI;
    }
    @Override
    public String toString(){
        return "Circle[Shape[color=" + this.getColor() + "filled=" + this.isFilled() + "],radius=" + this.getRadius() + "]";
    }
}
