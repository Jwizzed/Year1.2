package Exercises_on_Inheritance.ex4_2;

public class Student extends Person {
    public String program;
    public int year;
    public double fee;

    public Student(String name, String address) {
        super(name, address);
    }
    public String getProgram() {
        return program;
    }
    public int getYear() {
        return year;
    }
    public double getFee() {
        return fee;
    }
    public void setProgram(String program) {
        this.program = program;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }
    @Override
    public String toString(){
        return "Student[Person[name=" +this.getName() + "address=" +this.getAddress() + "],program=" + this.getYear() + ",fee=" + this.getFee() + "]";
    }
}
