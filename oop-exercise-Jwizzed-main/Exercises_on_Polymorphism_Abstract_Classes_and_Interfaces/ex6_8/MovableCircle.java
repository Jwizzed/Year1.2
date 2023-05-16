package Exercises_on_Polymorphism_Abstract_Classes_and_Interfaces.ex6_8;


public class MovableCircle implements Movable{
    private int radius;
    private MovablePoint center;

    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
        this.center = new MovablePoint(x, y, xSpeed, ySpeed);
        this.radius = radius;
    }
    @Override
    public String toString() {
        return  center + ",radius=" + radius;
    }

    @Override
    public void moveUp() {
        this.center.setY(this.center.getY()-this.center.getySpeed());
    }

    @Override
    public void moveDown() {
        this.center.setY(this.center.getY()+this.center.getySpeed());
    }

    @Override
    public void moveLeft() {
        this.center.setX(this.center.getX()-this.center.getxSpeed());
    }

    @Override
    public void moveRight() {
        this.center.setX(this.center.getX()+this.center.getxSpeed());
    }
}
