package Simulation;

import Observable.Observator;
import Observable.Subject;
import Simulation.Particle.Particle;
import Simulation.Repositiory.Iterator;
import Simulation.Repositiory.Repositiory;

public class Move implements Subject {

    private Repositiory particles;
    private Surface surface;
    private Observator o;
    private ColisionChecker colisionChecker;

    public Move(Surface surface, Repositiory particles ){
        this.surface = surface;
        this.particles = particles;
        colisionChecker = new ColisionChecker(surface);
    }


    private void checkColisions( Iterator iter  ){
        Particle currentParticle = iter.getItem();
        colisionChecker.HorizontalWall( currentParticle );
        colisionChecker.VerticalWall( currentParticle );

        Iterator iter2 = particles.getIterator(iter.getCurrentElementId() );
        while ( iter2.hasNext() ){
            colisionChecker.checkParticles( currentParticle, iter2.nextItem());
        }

    }

    public void step(){
        Iterator iter = particles.getIterator();
        while( iter.hasNext() ){
            Particle currentParticle = iter.nextItem();
            checkColisions( iter );
            currentParticle.incrementPosition();
        }
        o.notifyObservetor();
    }


    @Override
    public void registerObservator(Observator o) {
        this.o = o;
    }
}
