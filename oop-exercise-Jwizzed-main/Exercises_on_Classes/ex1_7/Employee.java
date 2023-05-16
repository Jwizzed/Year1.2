package Exercises_on_Classes.ex1_7;

public class Employee {
    public int id;
    public String firstName;
    public String lastName;
    public int salary;

    public Employee(int id, String firstName, String lastName, int salary){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }
    public int getID(){
        return this.id;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getName(){
        return this.firstName +" "+ this.lastName;
    }
    public int getSalary(){
        return this.salary;
    }
    public void setSalary(int salary){
        this.salary = salary;
    }
    public int getAnnualSalary(){
        return this.salary * 12;
    }
    public int raiseSalary(int percent){
        return this.salary + (this.salary *percent/100);
    }
    public String toString(){
        return "Exercises_on_Classes.ex1.ex1_7.Employee[id=" + this.id + ",name=" + getName() + ",salary=" + this.salary + "]";
    }
}

