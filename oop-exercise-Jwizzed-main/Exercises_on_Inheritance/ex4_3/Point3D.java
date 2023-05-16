package Exercises_on_Inheritance.ex4_3;

public class Point3D extends Point2D{
    private float z;
    public Point3D(float x, float y, float z){
        super(x,y);
        this.z = z;
    }

    public Point3D() {
        this.z = 0.0f;
    }

    public float getZ() {
        return z;
    }
    public void setZ(float z){
        this.z = z;
    }
    public float[] getXYZ(){
        float[] result = new float[3];
        result[0] = getX();
        result[1] = getY();
        result[2] = getZ();
        return result;

    }
    public void setXYZ(float x, float y, float z){
        this.setX(x);
        this.setY(y);
        this.setZ(z);
    }
    public String toString(){
        return "(" +this.getX() +","+this.getY() +","+ this.getZ()+ ")";
    }
}
