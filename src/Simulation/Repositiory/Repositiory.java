package Simulation.Repositiory;

import Simulation.Memento.State;
import Simulation.Particle.Particle;
import Simulation.Particle.ParticleGenerator;
import Simulation.Surface;

import java.util.ArrayList;
import java.util.List;

public class Repositiory {

    private ArrayList<Particle> list;

    public Repositiory(Surface surface, int particleAmmount ){
        list  = ParticleGenerator.generateParticles(surface, particleAmmount);

    }

    public void loadStates( List<State> statesList ) {
        int i = 0;
        for( State state : statesList) {
            list.get(i).setState(state);
            i++;
        }
    }

    public List<State> getStatesList() {
        List<State> stateList = new ArrayList<>();
        for( Particle particle : list){
            stateList.add(particle.createMemento());
        }
        return stateList;
    }

    public Particle get(int id){
        return this.list.get(id);
    }


    public Iterator getIterator(){
        return new Iterator(this);
    }

    public Iterator getIterator(int currentItem ){
        return new Iterator(this, currentItem);
    }

    public int size(){
        return list.size();
    }

}


