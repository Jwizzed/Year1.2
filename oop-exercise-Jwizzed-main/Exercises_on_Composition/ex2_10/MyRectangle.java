package Exercises_on_Composition.ex2_10;


public class MyRectangle{
    MyPoint top_left;
    MyPoint bottom_right;

    public MyRectangle(){
        this(-1, 1,1,-1);
    }
    public MyRectangle(int x1, int y1, int x2, int y2){
        this.top_left = new MyPoint(x1, y1);
        this.bottom_right = new MyPoint(x2, y2);
    }
    public MyRectangle(MyPoint pos1 , MyPoint pos2){
        this.top_left = pos1;
        this.bottom_right = pos2;
    }

    public MyPoint getTop_left() {
        return top_left;
    }

    public void setTop_left(MyPoint top_left) {
        this.top_left = top_left;
    }

    public MyPoint getBottom_right() {
        return bottom_right;
    }

    public void setBottom_right(MyPoint bottom_right) {
        this.bottom_right = bottom_right;
    }

    public boolean isTop_left(MyPoint another){
        return (this.top_left.getXY() == another.getXY());
    }

    public boolean Bottom_right(MyPoint another){
        return (this.bottom_right.getXY() == another.getXY());
    }
    public String toString(){
        return "Hello world the Top_left is at " + this.getTop_left().getX() + "," + this.top_left.getY() + ",Bottom_right is at " + this.getBottom_right().getX() + "," + this.getBottom_right().getY();
    }
}
