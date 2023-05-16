package Exercises_on_Composition.ex2_4;

public class Invoice {
    private int id;
    private Customer customer;
    private double amount;

    public Invoice(int id, Customer customer, double amount) {
        this.id = id;
        this.customer = customer;
        this.amount = amount;
    }

    public int getID() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public String getCustomerName(){
        return this.customer.getName();
    }
    public int getCustomerID(){
        return this.customer.getID();
    }
    public int getCustomerDiscount(){
        return this.customer.getDiscount();
    }
    public double getAmountAfterDiscount(){
        return this.amount - (this.amount * this.customer.getDiscount() / 100);
    }
    public String toString(){
        return "Invoice[id=" + this.id + ",customer=" + this.customer.toString() + ",amount=" + this.amount + "]";
    }
}
