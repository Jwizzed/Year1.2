package Exercises_on_Composition.ex2_8;


public class MyCircle {
    private MyPoint center;
    private int radius;

    public MyCircle(){
        this(0,0, 1);
    }
    public MyCircle(int x, int y, int radius){
        this.center = new MyPoint(x,y);
        this.radius = radius;
    }
    public MyCircle(MyPoint center, int radius){
        this.center = center;
        this.radius = radius;
    }

    public MyPoint getCenter() {
        return center;
    }

    public void setCenter(MyPoint center) {
        this.center = center;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getCenterX(){
        return this.center.getX();
    }
    public void setCenterX(int x){
        this.center.setX(x);
    }
    public int getCenterY(){
        return this.center.getY();
    }
    public void setCenterY(int y){
        this.center.setY(y);
    }
    public int[] getCenterXY(){
        return this.center.getXY();
    }
    public void setCenterXY(int x, int y){
        this.center.setXY(x,y);
    }
    public String toString(){
        return "MyCircle[radius=" + this.radius + ",center=" + this.center.toString() + "]";
    }
    public double getArea(){
        return Math.PI * Math.pow(this.radius,2);
    }
    public double getCircumference(){
        return 2 * Math.PI * this.radius;
    }
    public double distance(MyCircle another){
        return this.center.distance(another.getCenter());
    }
}
