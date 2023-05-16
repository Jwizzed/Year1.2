package Exercises_on_Classes;

public class Date {
    public int day;
    public int month;
    public int year;

    public Date(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year= year;
    }
    public int getDay(){
        return this.day;
    }
    public int getMonth(){
        return this.month;
    }
    public int getYear(){
        return this.year;
    }
    public void setDay(int day){
        this.day = day;
    }
    public void setMonth(int month){
        this.month = month;
    }
    public void setYear(int year){
        this.year = year;
    }
    public void setDate(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public String toString(){
        return String.format("%02d",this.day) + "/" + String.format("%02d",this.month) + "/" + String.format("%04d",this.year);
    }
}

