package Exercises_on_Polymorphism_Abstract_Classes_and_Interfaces.ex6_6;

public class Cat extends Animal{
    public Cat(String name){
        super(name);
    }

    @Override
    public void greets() {
        System.out.println("Meow");
    }
}
