package Exercises_on_Classes.ex1_6;

public class Account {
    public String id;
    public String name;
    public int balance=0;

    public Account(){
        this("123", "jj");
    }

    public Account(String id, String name){
        this.id = id;
        this.name = name;
    }
    public Account(String id, String name, int balance){
        this.id = id;
        this.name =name;
        this.balance = balance;
    }
    public String getID(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public int getBalance(){
        return this.balance;
    }
    public int credit(int amount){
        this.balance += amount;
        return this.balance ;
    }
    public int debit(int amount){
        if(amount <= this.balance){
            this.balance -= amount;
        }
        else{
            System.out.println("Amount exceed balance");
        }
        return this.balance;
    }
    public int transferTo(Account another, int amount){
        if(amount <= this.balance){
            another.balance += amount;
            this.balance -= amount;
        }else{
            System.out.println("Amount exceeded balance");
        }
        return this.balance;
    }
    public String toString(){
        return "Exercises_on_Classes.ex1.ex1_6.Account[id=" +this.id + ",name="+ this.name + ",balance=" + this.balance + "]";
    }

}
