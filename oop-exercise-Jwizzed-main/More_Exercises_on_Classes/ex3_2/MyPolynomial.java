package More_Exercises_on_Classes.ex3_2;

public class MyPolynomial {
    private double[] coeffs;
    public MyPolynomial(double... coeffs){
        this.coeffs = coeffs;
    }

    public int getDegree(){
        return this.coeffs.length - 1;
    }
    public String toString(){
        String text = "";
        for(int i = getDegree(); i>=0; i--){
            if (i == 0){
                text += "C0";
            }else if (i == 1){
                text += "C1X";
            }else{
                text += "C" + i  +"X^" + i;
            }
        }
        return text;
    }
    public double evaluate(double x){
        double result = 0.0d;
        for(int i = getDegree(); i>= 0; i--){
            result += this.coeffs[i] * Math.pow(x,i);
        }
        return result;
    }
    public MyPolynomial add(MyPolynomial right){
        for(int i = getDegree(); i>=0; i--){
            if (i <= right.getDegree()) {
                this.coeffs[i] += right.coeffs[i];
            }
        }
        return this;
    }

    public MyPolynomial multiply(MyPolynomial right){
        for(int i = getDegree(); i>=0; i--){
            if (i <= right.getDegree()) {
                this.coeffs[i] *= right.coeffs[i];
            }
        }
        return this;
    }

}

