package Simulation;

import Observable.Observator;
import Simulation.Particle.Particle;
import Simulation.Repositiory.Iterator;
import Simulation.Repositiory.Repositiory;

import javax.swing.*;
import java.awt.*;


public class Board extends JPanel implements Observator {

    private Repositiory repositiory;

    public Board(Surface surface, Repositiory repositiory){
        this.repositiory = repositiory;
        setPreferredSize(new Dimension(surface.getWidth(), surface.getHeight()));
        setBackground(new Color(90, 255, 79) );
    }

    @Override
    protected void paintComponent( Graphics g ){
        super.paintComponent(g);
        Iterator particlesIter = repositiory.getIterator();

        while (particlesIter.hasNext()){
            Particle p = particlesIter.nextItem();
            g.setColor(p.getColor());
            g.fillOval((int) p.getX(), (int) p.getY(), 20, 20);
        }
    }


    @Override
    public void notifyObservetor() {
        repaint();
    }
}
