package Exercises_on_Inheritance.ex4_5;

public class Rectangle extends Shape{
    private double width;
    private double length;
    public Rectangle(){
        this.length = 1.0;
        this.width = 1.0;
    }
    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }
    public Rectangle(double width, double length, String color, boolean filled){
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
    public double getArea(){
        return this.width *  this.length;
    }
    public double getPerimeter(){
        return this.width * 2 +  2* this.length;
    }
    @Override
    public String toString(){
        return "Rectangle[Shape[color=" +this.getColor() + ",filled=" + this.isFilled() + ",width=" + this.getWidth() + ",length=" + this.getLength() +"]";
    }
}
