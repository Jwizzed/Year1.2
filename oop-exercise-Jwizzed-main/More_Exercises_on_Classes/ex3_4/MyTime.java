package More_Exercises_on_Classes.ex3_4;

public class MyTime {
    public int hour;
    public int minute;
    public int second;

    public MyTime(int hour, int minute, int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    public int getHour(){
        return this.hour;
    }
    public int getMinute(){
        return this.minute;
    }
    public int getSecond(){
        return this.second;
    }
    public void setHour(int hour){
        if(hour >= 24) {
            this.hour = 0;
        }
        else if (hour < 0){
            this.hour=23;
        }
        else{
            this.hour = hour;
        }
    }
    public void setMinute(int minute){
        if(minute >= 60) {
            setHour(this.hour += 1);
            this.minute = 0;
        }
        else if(minute <0){
            setHour(this.hour -= 1);
            this.minute=60+minute;
        }
        else {
            this.minute = minute;
        }
    }
    public void setSecond(int second){
        if(second >= 60) {
            this.second = second%60;
            setMinute(this.minute+=second/60);
        }
        else if(second <0){
            setMinute(this.minute-=1);
            this.second = 60+second;
        }
        else{
            this.second = second;
        }
    }
    public void setTime(int hour, int minute, int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    public String toString(){
        return String.format("%02d", this.hour) + ":" + String.format("%02d", this.minute) + ":" + String.format("%02d", this.second);
    }
    public MyTime nextSecond(){
        setSecond(this.second+=1);
        return this;
    }
    public MyTime previousSecond(){
        setSecond(this.second-=1);
        return this;
    }
    public MyTime nextMinute(){
        setMinute(this.minute+=1);
        return this;
    }
    public MyTime previousMinute(){
        setMinute(this.minute-=1);
        return this;
    }
    public MyTime nextHour(){
        setHour(this.hour+=1);
        return this;
    }
    public MyTime previousHour(){
        setHour(this.hour-=1);
        return this;
    }

}
