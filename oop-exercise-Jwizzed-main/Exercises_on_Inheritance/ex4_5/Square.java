package Exercises_on_Inheritance.ex4_5;

public class Square extends Rectangle {
    public Square() {
    }
    public Square(double side){
        super(side,side);
    }
    public Square(double side, String color, boolean filled){
        super(side, side, color, filled);
    }
    public double getSide(){
        return this.getLength();
    }
    public void setSide(double side){
        setLength(side);
        setWidth(side);
    }
    public void setWidth(double side){
        super.setWidth(side);
    }
    public void setLength(double side){
        super.setLength(side);
    }
    public String toString(){
        return "Rectangle[Shape[color=" + this.getColor() + "filled=" + this.isFilled() + "],width="+ this.getWidth() + ",length="+ this.getLength() + "]";
    }
}
