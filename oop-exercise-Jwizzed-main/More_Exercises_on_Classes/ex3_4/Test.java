package More_Exercises_on_Classes.ex3_4;

public class Test {
    public static void main(String[] args) {
        MyTime myTime = new MyTime(23,59,59);
        System.out.println(myTime);
        myTime.nextHour();
        System.out.println(myTime);
        myTime.nextSecond();
        System.out.println(myTime);
    }
}
