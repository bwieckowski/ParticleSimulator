package Simulation.Particle;

import java.io.Serializable;

public class Vector2D implements Serializable {

    private double x;
    private double y;

    public Vector2D( double x, double y){
        this.x = x;
        this.y = y;
    }

    public Vector2D(){
        this.x = 0;
        this.y = 0;
    }

    public String toString() {
        return "("+x+","+y+")";
    }

    public double distance( Vector2D v2){
        return Math.sqrt( Math.pow(this.x - v2.getX(),2) + Math.pow(this.y - v2.getY(),2));
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Vector2D add(Vector2D v) {
        Vector2D v1 = new Vector2D();
        v1.x = this.x + v.getX();
        v1.y = this.y + v.getY();
        return v1;
    }
}
