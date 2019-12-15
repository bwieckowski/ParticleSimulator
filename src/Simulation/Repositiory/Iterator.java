package Simulation.Repositiory;

import Simulation.Particle.Particle;

public class Iterator {
    private int nextElement;
    private Repositiory repo;

    public Iterator( Repositiory repo ){
        nextElement = 0;
        this.repo = repo;
    }

    public Iterator(Repositiory repo, int currentElement ){
        this.nextElement = currentElement;
        this.repo = repo;
    }

    public int getCurrentElementId() {
        return nextElement - 1;
    }

    public boolean hasNext(){
        if( nextElement < repo.size() )
            return true;
        return false;
    }

    public Particle nextItem(){
        if( hasNext() )
            return  repo.get(nextElement++);
        else
            return null;
    }
    public Particle getItem(){
        return repo.get(nextElement-1);
    }
}
