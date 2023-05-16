package Exercises_on_Classes.ex1_3;

public class Rectangle{
    public float length;
    public float width;

    public Rectangle(){
        this.length = 1.0f;
        this.width = 1.0f;
    }
    public Rectangle(float length, float width){
        this.length = length;
        this.width = width;
    }
    public float getLength(){
        return this.length;
    }
    public float getWidth(){
        return this.width;
    }
    public void setLength(float length){
        this.length = length;
    }
    public void setWidth(float width){
        this.width = width;
    }
    public double getArea(){
        return this.width * this.length;
    }
    public double getPerimeter(){
        return (this.length *2) + (this.width*2);
    }
    public String toString(){
        return "Exercises_on_Classes.ex1.ex1_3.Rectangle[length=" + this.length + ",width=" + this.width + "]";
    }
}