package Exercises_on_Polymorphism_Abstract_Classes_and_Interfaces.ex6_6;

public abstract class Animal {
    private String name;
    public Animal(String name){
        this.name = name;
    }
    public abstract void greets();
}
