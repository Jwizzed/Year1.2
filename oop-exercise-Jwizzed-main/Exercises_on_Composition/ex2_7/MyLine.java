package Exercises_on_Composition.ex2_7;

public class MyLine {
    private MyPoint begin;
    private MyPoint end;
    public MyLine(int x1, int y1, int x2, int y2){
        this.begin = new MyPoint(x1,y1);
        this.end = new MyPoint(x2,y2);
    }
    public MyLine(MyPoint begin, MyPoint end){
        this.begin = begin;
        this.end = end;
    }

    public MyPoint getBegin() {
        return begin;
    }

    public void setBegin(MyPoint begin) {
        this.begin = begin;
    }

    public MyPoint getEnd() {
        return end;
    }

    public void setEnd(MyPoint end) {
        this.end = end;
    }
    public int getBeginX(){
        return this.begin.getX();
    }
    public void setBeginX(int x){
        this.begin.setX(x);
    }
    public int getBeginY(){
        return this.begin.getY();
    }
    public void setBeginY(int y){
        this.begin.setY(y);
    }
    public int getEndX(){
        return this.end.getX();
    }
    public void setEndX(int x){
        this.end.setX(x);
    }
    public int getEndY(){
        return this.end.getY();
    }
    public void setEndY(int y){
        this.end.setY(y);
    }
    public int[] getBeginXY(){
        int[] result = new int[2];
        result[0] = this.begin.getX();
        result[1] = this.begin.getY();
        return result;
    }
    public void setBeginXY(int x, int y){
        this.begin.setX(x);
        this.begin.setY(y);
    }
    public int[] getEndXY(){
        int[] result = new int[2];
        result[0] = this.end.getX();
        result[1] = this.end.getY();
        return result;
    }
    public void setEndXY(int x, int y){
        this.end.setX(x);
        this.end.setY(y);
    }
    public double getLength(){
        return this.begin.distance(this.end);
    }
    public double getGradient(){
        return Math.atan2(getEndX()-getBeginX(), getEndY()-getBeginY());
    }
    public String toString(){
        return "MyLine[begin=(" + getBeginX() + "," + getBeginY() +")" +",end=" + getEndX() + "," + getEndY() +")]";
     }
}
