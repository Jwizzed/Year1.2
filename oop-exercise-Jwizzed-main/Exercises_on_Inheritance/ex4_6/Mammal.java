package Exercises_on_Inheritance.ex4_6;

public class Mammal extends Animal{
    public Mammal(String name){
        super(name);
    }
    public String toString(){
        return "Mammal: "+ "Mammal[" + super.toString() + "]";
    }
}
