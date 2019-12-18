package Simulation.Memento;

import java.io.Serializable;

public class State implements Serializable {
    private Object state;


    public State(Object state){
        this.state = state;
    }
    public Object getState() {
        return state;
    }

    public void setState(Object state) {
        this.state = state;
    }

}
