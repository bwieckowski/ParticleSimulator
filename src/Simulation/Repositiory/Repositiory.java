package Simulation.Repositiory;

import Simulation.Particle.Particle;
import Simulation.Particle.ParticleGenerator;
import Simulation.Surface;

import java.util.ArrayList;

public class Repositiory {

    private ArrayList<Particle> list;

    public Repositiory(Surface surface, int particleAmmount ){
        list  = ParticleGenerator.generateParticles(surface, particleAmmount);

    }

    public Particle get(int id){
        return this.list.get(id);
    }

    public ArrayList<Particle> getAll(){
        return list;
    }

    public void push( Particle Particle ) {
        this.list.add(Particle);
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
    public void remove( Particle Particle ) {
        this.list.remove(Particle);
    }

    public void showItems() {
        for ( Particle item : list) {
            System.out.println(item.toString());
        }
    }

}


