import Observable.Observator;
import Observable.Subject;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Move extends TimerTask implements Subject {
    private int timestamp = 10;

    private ArrayList<Particle> particles;
    private Surface surface;
    private Observator o;
    Timer timer;

    public Move( Surface surface, int n ){
        this.surface = surface;
        this.particles = ParticleGenerator.generateParticles(surface, n);
        timer = new Timer();
    }

    public Move( Surface surface, ArrayList<Particle> particles ){
        this.surface = surface;
        this.particles = particles;
        timer = new Timer();
    }


    public ArrayList<Particle> getParticles() {
        return particles;
    }


    private Vector2D HorizontalWall(Particle particle){
        Vector2D position = particle.getPosition();
        Vector2D speed = particle.getSpeed();

        if( position.getY() + speed.getY() > surface.getHeight() || position.getY() + speed.getY() < 0)
            speed.setY(-1 * speed.getY());

        return speed;
    }

    private Vector2D VerticalWall(Particle particle){
        Vector2D position = particle.getPosition();
        Vector2D speed = particle.getSpeed();

        if( position.getX() + speed.getX() > surface.getWidth() || position.getX() + speed.getX() < 0 )
            speed.setX(-1 * speed.getX());

        return speed;

    }

    private void checkParticles( Particle currentParticle, Particle nextParticle) {
        Vector2D currentNextPosition = currentParticle.getNextPosition();
        Vector2D nextParticleNextPosition = nextParticle.getNextPosition();

        if( currentNextPosition.distance(nextParticleNextPosition) < 20 ){
            Vector2D currentSpeed = currentParticle.getSpeed();
            currentParticle.setSpeed(nextParticle.getSpeed());
            nextParticle.setSpeed(currentSpeed);

        }

    }

    private void checkColisions(Particle currentParticle, int nextParticleID ){
        Vector2D position = currentParticle.getPosition();
        Vector2D speed = currentParticle.getSpeed();
        speed = HorizontalWall( currentParticle);
        speed = VerticalWall( currentParticle );
        currentParticle.setSpeed(speed);

        for ( int i = nextParticleID; i < particles.size(); i++){
            checkParticles( currentParticle, particles.get(i));
        }

    }

    @Override
    public void run(){
        int nextParticle = 1;
        for( Particle p : particles){
            checkColisions(p, nextParticle);
            p.incrementPosition();
            nextParticle += 1;
        }
        o.notifyObservetor();
    }

    public void start(){
        timer.scheduleAtFixedRate( this, timestamp, timestamp);
    }

    public void stop(){
        timer.cancel();
    }

    @Override
    public void registerObservator(Observator o) {
        this.o = o;
    }
}
