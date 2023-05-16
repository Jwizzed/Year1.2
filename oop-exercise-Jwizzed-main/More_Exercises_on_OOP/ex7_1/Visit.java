package More_Exercises_on_OOP.ex7_1;
import java.util.Date;

public class Visit {
    private Customer customer;
    private Date date;
    private double serviceExpense;
    private double productExpense;

    public Visit(String name, Date date){
        this.customer = new Customer(name);
        this.date = date;
    }
    public String getName(){
        return this.customer.getName();
    }
    public double getServiceExpense(){
        return this.serviceExpense;
    }
    public double getProductExpense(){
        return productExpense;
    }
    public void setServiceExpense(double ex) {
        this.serviceExpense = ex;
    }
    public void setProductExpense(double ex) {
        this.productExpense = ex;
    }
    public double getTotalExpense(){
        return (getProductExpense() - (getProductExpense() * DiscountRate.getProductDiscountRate(getName()))) +
                getServiceExpense() - (getServiceExpense() * DiscountRate.getServiceDiscountRate(getName()));
    }
    public String toString(){
        return " ";
    }
}

