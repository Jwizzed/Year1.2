package Exercises_on_Composition.ex2_2;

public class Book {
    private String name;
    private Author[] authors;
    private Author author;
    private double price;
    private int qty;

    public Book(String name, Author[] authors, double price) {
        this(name, authors, price, 0);
    }

    public Book(String name, Author[] authors, double price, int qty) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qty = qty;
    }


    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }
    public void setPrice(double price){
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }


    public String toString(){
        return "Book[name=" + this.name + ",authors={" + getAuthorNames() + "}" + ",price=" + this.price + ",qty=" + this.qty+"]";
    }
    public String getAuthorNames(){
        String Names = "";
        for(int i = 0; i < authors.length; i++) {
            if (i == 0) {
                Names += authors[i];
            } else {
                Names += ", " + authors[i];
            }
        }
        return Names;

    }


}

