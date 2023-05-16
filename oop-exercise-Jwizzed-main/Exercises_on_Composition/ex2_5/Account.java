package Exercises_on_Composition.ex2_5;

public class Account {
    private int id;
    private Customer customer;
    private double balance;

    public Account(int id, Customer customer) {
        this(id, customer, 0.0d);
    }
    public Account(int id, Customer customer, double balance) {
        this.id = id;
        this.customer = customer;
        this.balance = balance;
    }
    public int getID() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public String getCustomerName(){
        return this.customer.getName();
    }
    public Account deposit(double amount){
        this.balance += amount;
        return this;
    }
    public Account withdraw(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;

        } else {
            System.out.println("amount withdrawn exceeds the current balance!");
        }
        return this;
    }

    public String toString(){
        return  customer.toString()+"balance=$" + String.format("%.2f",getBalance());
    }
}
