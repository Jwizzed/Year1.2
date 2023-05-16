package More_Exercises_on_Classes.ex3_3;

import java.math.BigInteger;

public class TestBigInteger {
    public static void main(String[] arg){
        BigInteger num1 = new BigInteger("11111111111111111111111111111111111111111111111111111111111111");
        BigInteger num2 = new BigInteger("22222222222222222222222222222222222222222222222222");
        System.out.println(num1.add(num2));
    }
}
