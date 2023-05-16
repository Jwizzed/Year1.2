package Exercises_on_Classes.ex1_1;

public class Circle {
    public double radius;
    public String color;

    public Circle(){
        this(1.0, "red");
    }
    public Circle(int radius){
        this(radius, "red");
    }
    public Circle(double r, String color){
        this.radius = r;
        this.color= color;

    }
    public double getRadius(){
        return this.radius;
    }
    public void setRadius(double new_radius){
        this.radius = new_radius;
    }
    public String getColor(){
        return this.color;
    }
    public void setColor(String color){
        this.color = color;
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
