package Exercises_on_Polymorphism_Abstract_Classes_and_Interfaces.ex6_5;

public class ResizableCircle extends Circle implements Resizable{
    public ResizableCircle(double radius){
        super(radius);
    }
    public String toString(){
        return "ResizableCircle[" + super.toString() + "]";
    }
    @Override
    public void resize(int percent) {
        super.radius *= percent/100.0;
    }
}
