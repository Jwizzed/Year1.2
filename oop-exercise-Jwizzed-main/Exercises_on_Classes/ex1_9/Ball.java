package Exercises_on_Classes.ex1_9;

public class Ball{
    public float x;
    public float y;
    public int radius;
    public float xDelta;
    public float yDelta;

    public Ball(float x, float y, int radius, float xDelta, float yDelta){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.xDelta = xDelta;
        this.yDelta = yDelta;
    }
    public float getX(){
        return this.x;
    }
    public float getY(){
        return this.y;
    }
    public void setX(float x){
        this.x = x;
    }
    public void setY(float y){
        this.y =y;
    }
    public int getRadius(){
        return this.radius;
    }
    public void setRadius(int radius){
        this.radius = radius;
    }
    public float getXDelta(){
        return this.xDelta;
    }
    public void setXDelta(float xDelta){
        this.xDelta = xDelta;
    }
    public float getYDelta(){
        return this.yDelta;
    }
    public void setYDelta(float yDelta){
        this.yDelta = yDelta;
    }
    public void move(){
        this.x += this.xDelta;
        this.y += this.yDelta;
    }
    public void reflectHorizontal(){
        this.xDelta *= -1;
    }
    public void reflectVertical(){
        this.yDelta *= -1;
    }
    public String toString(){
        return "Exercises_on_Classes.ex1.ex1_9.Ball(" + this.x + "," + this.y + "),speed=(" + this.xDelta + "," + this.yDelta + ")]";
    }
}