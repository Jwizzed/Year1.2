package More_Exercises_on_Classes.ex3_5;

public class MyDate {
    private int year;
    private int month;
    private int day;
    public static final String[] MONTHS = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    public static final String[] DAYS = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    public static final int[] DAYS_INT_MONTHS = {31,28,31,30,31,30,31,31,30,31,30,31};
    public static boolean isLeapYear(int year){
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    public static boolean isValidDate(int year, int month, int day){
        if ((year >= 1 && year <= 9999) && (month >= 1 && month <= 12) && (day >= 1 && day <= DAYS_INT_MONTHS[month-1])){
            return true;
        }
        if (month == 2 && isLeapYear(year)){
            return day <= 29;
        }
        return false;
    }
    public static int getDayOfWeek(int year, int month, int day){
        int total_days = 0;
        if (isValidDate(year, month, day)){
            for (int i = year-1; i >= 1; i--){
                if (isLeapYear(i)) total_days += 366;
                 else total_days += 365;
            }
        }
        for (int i = month-1; i >=1; i--){
            if (i == 2 && isLeapYear(year)) total_days += 29;
            else total_days += DAYS_INT_MONTHS[i-1];
        }
        return (total_days + day) % 7;
    }

    public MyDate(int year, int month, int day) {
        setDate(year, month, day);

    }
    public void setDate(int year, int month, int day){
        if (isValidDate(year, month, day)){
            this.year = year;
            this.month = month;
            this.day = day;
        }else{
            throw new IllegalArgumentException("Invalid year, month, or day!");
        }
    }
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(isValidDate(getYear(),getMonth(),getDay())){
            this.year = year;
    }else{
            throw new IllegalArgumentException("Invalid year");
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (isValidDate(getYear(),getMonth(),getDay())){
            this.month = month;
        }else{
            throw new IllegalArgumentException("Invalid month");
        }
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
//        if ((day >= 1 && day <= DAYS_INT_MONTHS[month-1]) || (month == 2 && isLeapYear(year) && day <= 29)){
        if (isValidDate(getYear(),getMonth(),getDay())){
            this.day = day;
        } else{
            throw new IllegalArgumentException("Invalid day");
        }
    }
    public String toString(){
        return DAYS[getDayOfWeek(getYear(), getMonth(), getDay())] + " " + getDay() + " " + MONTHS[getMonth()-1] + " " + getYear();
    }
    public MyDate nextDay(){
        if (isValidDate(getYear(), getMonth(), getDay()+1)){
            setDay(getDay()+1);
        } else if (isValidDate(getYear(), getMonth()+1, 1)){
            setMonth(getMonth()+1);
            setDay(1);
        } else if (isValidDate(getYear()+1, 1, 1)){
            setYear(getYear()+1);
            setMonth(1);
            setDay(1);
        } else{
            throw new IllegalArgumentException("Invalid year, month, or day!");
        }
        return this;
    }


    public MyDate nextMonth(){
        if (isValidDate(getYear(), getMonth()+1, getDay())){
            setMonth(getMonth() +1);
        } else if (isValidDate(getYear() + 1, getMonth(), getDay())) {
            setDate(getYear() +1, 1, 1);
        }
        return this;
    }
    public MyDate nextYear(){
        setYear(getYear() +1);
        return this;
    }
    public MyDate previousDay(){
        if(isValidDate(getYear(), getMonth(), getDay()-1)){
            setDay(getDay() - 1);
        }else if(isValidDate(getYear(), getMonth()-1, getDay())) {
            if (month == 2 && isLeapYear(getYear())){
                setDate(getYear(), getMonth()-1, 29);
            }else {
                setDate(getYear(), getMonth()-1, DAYS_INT_MONTHS[month-1]);
            }
        }else if(isValidDate(getYear()-1, getMonth(), getDay())){
            setDate(getYear()-1 , 12, DAYS_INT_MONTHS[11]);
        }
        return this;
    }
    public MyDate previousMonth() {
        if(isValidDate(getYear(), getMonth()-1, DAYS_INT_MONTHS[getMonth()-2])){
            setDate(getYear(), getMonth()-1, DAYS_INT_MONTHS[getMonth()-2]);

        }else if(isValidDate(getYear()-1, getMonth(), getDay())) {
            setDate(getYear()-1, 12, DAYS_INT_MONTHS[getMonth()-1]);
        }
        return this;
    }
    public MyDate previousYear(){
        setDate(getYear()-1 , getMonth(), DAYS_INT_MONTHS[getMonth()-1]);
        return this;
    }

}

