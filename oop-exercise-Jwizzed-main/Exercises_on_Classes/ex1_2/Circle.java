package Exercises_on_Classes.ex1_2;
public class Circle {
    public double radius;

    public Circle(double r){
        this.radius = r;
    }
    public Circle(){
        this(1.0);
    }
    public double getRadius(){
        return this.radius;
    }
    public void setRadius(double new_radius){
        this.radius = new_radius;
    }

    public double getArea(){
        return Math.PI * this.radius* this.radius;
    }
    public double getCircumference(){
        return 2*this.radius* Math.PI;
    }
    public String toString(){
        return "Circle[radius=" + this.radius + "]";
    }
}