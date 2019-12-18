package Simulation.Particle;

import Simulation.Memento.State;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Particle {

    private Vector2D position;
    private Vector2D speed;
    private Color color;
    private double radius;

    public Particle(Vector2D position, Vector2D speed, double radius) {
        this.position = position;
        this.speed = speed;
        this.radius = radius;
    }

    public void setColor( Color color ){
        this.color = color;
    }

    public double getX(){
        return position.getX();
    }

    public double getY(){
        return position.getY();
    }

    public State createMemento(){
        Map<String,Object> stateMap = new HashMap<>();
        stateMap.put("position", position);
        stateMap.put("speed", speed);
        stateMap.put("color", color);
        stateMap.put("radius",radius);
        return new State(stateMap);
    }

    public void setState( State state){
        Map<String,Object> stateMap = (Map<String,Object>) state.getState();
        this.color = (Color) stateMap.get("color");
        this.speed = (Vector2D) stateMap.get("speed");
        this.position = (Vector2D) stateMap.get("position");
        this.radius = (double) stateMap.get("radius");

    }

    public Color getColor(){
       return color;
    }

    public void incrementPosition(){
        this.position = getNextPosition();
    }

    public Vector2D getPosition() {
        return position;
    }

    public void setPosition(Vector2D position) {
        this.position = position;
    }

    public Vector2D getSpeed() {
        return speed;
    }

    public void setSpeed(Vector2D speed) {
        this.speed = speed;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Vector2D getNextPosition(){
       return this.position.add(speed);
    }

}
