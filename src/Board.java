import Observable.Observator;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.TimerTask;

public class Board extends JPanel implements Observator {

    private int particleAmount;
    private Move moveControler;

    public Board(Surface surface, int particleAmount){
        this.particleAmount = particleAmount;
        setPreferredSize(new Dimension(surface.getWidth(), surface.getHeight()));
        setBackground(new Color(90, 255, 79) );
        moveControler = new Move(surface, particleAmount);
        moveControler.registerObservator(this);
        moveControler.start();
    }

    @Override
    protected void paintComponent( Graphics g ){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for ( Particle p : moveControler.getParticles()){
            Vector2D v = p.getPosition();
            g.setColor(p.getColor());
            g.fillOval((int) v.getX(), (int) v.getY(), 20, 20);
        }
    }


    @Override
    public void notifyObservetor() {
        repaint();
    }
}
