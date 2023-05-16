package More_Exercises_on_OOP.ex7_2;

public class Point {
    private int x;
    private int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
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
        return "HI";
    }
    public double distance(Point another){
        return Math.sqrt(Math.pow(another.x - x,2) + Math.pow(another.y-x,2));
    }
}