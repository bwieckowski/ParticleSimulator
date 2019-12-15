import Simulation.Repositiory.Repositiory;
import Simulation.Simulation;
import Simulation.Surface;
import Simulation.Board;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView {
    private JPanel mainPanel;
    private JPanel simulationPanel;
    private JPanel menuPanel;
    private JButton startStopBtn;
    private JButton loadBtn;
    private JButton saveBtn;

    private int WINDOW_HEIGHT = 200;
    private int WINDOW_WIDTH = 200;
    private int PARTICLE_AMOUNT = 5;

    private boolean isSimulateRun = true;
    private Simulation simulation;

    public MainView() {

        Surface surface = new Surface(WINDOW_HEIGHT, WINDOW_WIDTH);
        Repositiory repo = new Repositiory(surface, PARTICLE_AMOUNT);
        Board board = new Board(surface, repo);
        simulation = new Simulation( board, surface, repo );

        simulationPanel.setLayout( new BoxLayout(simulationPanel,BoxLayout.LINE_AXIS));
        simulationPanel.add(board);
        initButtons();
        simulation.start();

    }

    private void initButtons(){
        startStopBtn.addActionListener(new StopStartActionListener());
    }

    private class StopStartActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(isSimulateRun) {
                simulation.stop();
            }
            else {
                simulation.start();
            }
            isSimulateRun = !isSimulateRun;
        }
    }


    public JPanel getView(){
        return mainPanel;
    }

}
