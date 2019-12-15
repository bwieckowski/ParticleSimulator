package Simulation;

import Simulation.Repositiory.Repositiory;

import java.util.Timer;
import java.util.TimerTask;

public class Simulation{

    private int timestamp = 10;
    private Timer timer;
    private Move move;


    public Simulation(Board board, Surface surface, Repositiory repo){
        move = new Move(surface, repo);
        move.registerObservator(board);
    }


    public void start(){
        timer = new Timer();
        timer.scheduleAtFixedRate( new MakeStep(), timestamp, timestamp);
    }

    public void stop(){
        timer.cancel();
    }

    private class MakeStep extends TimerTask {

        @Override
        public void run() {
            move.step();
        }
    }

}
