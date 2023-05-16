package Exercises_on_Classes.ex1_5;

public class InvoiceItem{
    public String id;
    public String desc;
    public int qty;
    public double unitPrice;

    public InvoiceItem(String id, String desc, int qty, double unitPrice){
        this.id = id;
        this.desc = desc;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }
    public String getID(){
        return this.id;
    }
    public String getDesc(){
        return this.desc;
    }
    public int getQty(){
        return this.qty;
    }
    public void setQty(int qty){
        this.qty = qty;
    }
    public double getUnitPrice(){
        return this.unitPrice;
    }
    public void setUnitPrice(double unitPrice){
        this.unitPrice = unitPrice;
    }
    public double getTotal(){
        return this.unitPrice * this.qty;
    }
    public String toString(){
        return "Exercises_on_Classes.ex1.ex1_5.InvoiceItem[id=" + this.id + ",desc=" + this.desc + ",qty="+ this.qty + "unitPrice="+ getUnitPrice()+ "]";
    }
}