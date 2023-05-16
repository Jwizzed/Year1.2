package Exercises_on_Composition_vs_Inheritance.ex5_1;

public class Line {
    private Point begin;
    private Point end;
    public Line(Point begin, Point end) {
        this.begin = begin;
        this.end = end;
    }
    public Line(int beginX, int beginY, int endX, int endY){
        this.begin = new Point(beginX, beginY);
        this.end = new Point(endX, endY);
    }
    public Point getBegin() {
        return begin;
    }

    public void setBegin(Point begin) {
        this.begin = begin;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public String toString(){
        return getBegin()+ " " + getEnd();
    }
    public int getBeginX(){
        return getBegin().getX();
    }
    public int getBeginY(){
        return getBegin().getY();
    }
    public int getEndX(){
        return getEnd().getX();
    }
    public int getEndY(){
        return getEnd().getY();
    }
    public void setBeginX(int x){
        this.begin.setX(x);
    }
    public void setBeginY(int y){
        this.begin.setY(y);

    }
    public void setBeginXY(int x, int y){
        this.begin.setX(x);
        this.begin.setY(y);
    }
    public void setEndX(int x){
        this.end.setX(x);
    }
    public void setEndY(int y){
        this.end.setY(y);

    }
    public void setEndXY(int x, int y){
        this.end.setX(x);
        this.end.setY(y);
    }
    public int getLength(){
        return (int )Math.sqrt(Math.pow(getEndX() - getBeginX(), 2) + (Math.pow(getEndY() - getBeginY(), 2)));
    }



}
