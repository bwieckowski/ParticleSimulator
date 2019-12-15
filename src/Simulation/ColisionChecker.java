package Simulation;

import Simulation.Particle.Particle;
import Simulation.Particle.Vector2D;

public class ColisionChecker {

    private Surface surface;

    public ColisionChecker( Surface surface){
        this.surface = surface;
    }

    public void HorizontalWall(Particle particle){
        Vector2D position = particle.getNextPosition();
        Vector2D speed = particle.getSpeed();

        if( position.getY() > surface.getHeight() || position.getY() < 0) {
            speed.setY(-1 * speed.getY());
            particle.setSpeed(speed);
        }
    }

    public void VerticalWall(Particle particle){
        Vector2D position = particle.getNextPosition();
        Vector2D speed = particle.getSpeed();

        if( position.getX() > surface.getWidth() || position.getX() < 0) {
            speed.setX(-1 * speed.getX());
            particle.setSpeed(speed);
        }
    }

    public void checkParticles(Particle currentParticle, Particle nextParticle) {
        Vector2D currentNextPosition = currentParticle.getNextPosition();
        Vector2D nextParticleNextPosition = nextParticle.getNextPosition();

        if( currentNextPosition.distance(nextParticleNextPosition) < 20 ){
            Vector2D currentSpeed = currentParticle.getSpeed();
            currentParticle.setSpeed(nextParticle.getSpeed());
            nextParticle.setSpeed(currentSpeed);

        }

    }


}
