package More_Exercises_on_Classes.ex3_1;

public class MyComplex {
    private double real;
    private double imag;

    public MyComplex(){
        this.real = 0.0d;
        this.imag = 0.0d;
    }
    public MyComplex(double real, double imag){
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }
    public void setValue(double real, double imag){
        this.real = real;
        this.imag = imag;
    }
    public String toString(){
        return getReal() + "+" + getImag();
    }
    public boolean isReal(){
        return getImag() == 0;
    }
    public boolean isImaginary(){
        return getReal() == 0;
    }
    public boolean equals(double real, double imag){
        return getImag() == imag && getReal() == real;
    }
    public boolean equals(MyComplex another){
        return (this.getReal() == another.getReal()) && (this.getImag() == another.getImag());
    }
    public double magnitude(){
        return Math.sqrt(Math.pow(getReal(),2) + Math.pow(getImag(),2));
    }
    public double argument(){
        return Math.atan2(getImag(), getReal());
    }
    public MyComplex add(MyComplex right){
        this.real += right.getReal();
        this.imag += right.getImag();
        return this;
    }
    public MyComplex addNew(MyComplex right){
        return new MyComplex(right.getReal(), right.getImag());
    }

    public MyComplex subtract(MyComplex right){
        this.real -= right.getReal();
        this.imag -= right.getImag();
        return this;
    }
    public MyComplex subtractNew(MyComplex right){
        return new MyComplex(right.getReal(), right.getImag());
    }

    public MyComplex multiply(MyComplex right){
        this.real *= right.getReal();
        this.imag *= right.getImag();
        return this;
    }

    public MyComplex divide(MyComplex right){
        this.real /= right.getReal();
        this.imag /= right.getImag();
        return this;
    }

    public MyComplex conjugate(){
        this.imag *= -1;
        return this;
    }
}
