import javax.swing.*;

public class Simulation {

    private int WINDOW_HEIGHT = 200;
    private int WINDOW_WIDTH = 200;
    private int PARTICLE_AMOUNT = 4;


    public Simulation(){

        JFrame frame = new JFrame();
        frame.setTitle("window");
        frame.setVisible(true);
        frame.setResizable(false);
        Surface surface = new Surface(WINDOW_HEIGHT, WINDOW_WIDTH);
        Board board = new Board(surface, PARTICLE_AMOUNT);

        frame.setContentPane(board);
        frame.pack();



    }
}
