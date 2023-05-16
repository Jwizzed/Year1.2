package Exercises_on_Composition.ex2_9;

public class MyPoint {

    private int x;
    private int y;

    public MyPoint(){
        this(0,0);
    }
    public MyPoint(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public int[] getXY(){
        int[] result = new int[2];
        result[0] = getX();
        result[1] = getY();
        return result;
    }
    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return "(" + this.x + "," + this.y + ")";
    }
    public double distance(){
        return Math.sqrt(Math.pow(this.x,2) + Math.pow(this.y,2));
    }
    public double distance(int x, int y){
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
    }
    public double distance(MyPoint another){
        return Math.sqrt(Math.pow(this.x - another.getX(),2) + Math.pow(this.y - another.getY(),2));
        }
    }



