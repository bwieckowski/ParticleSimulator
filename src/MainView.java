import DataManagment.DataLoader;
import DataManagment.DataSaver;
import Simulation.Memento.State;
import Simulation.Repositiory.Iterator;
import Simulation.Repositiory.Repositiory;
import Simulation.Simulation;
import Simulation.Surface;
import Simulation.Board;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainView extends JFrame{
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
    private Repositiory repo;
    private Board board;

    public MainView() {

        Surface surface = new Surface(WINDOW_HEIGHT, WINDOW_WIDTH);
        repo = new Repositiory(surface, PARTICLE_AMOUNT);
        Board board = new Board(surface, repo);
        simulation = new Simulation( board, surface, repo );

        simulationPanel.setLayout( new BoxLayout(simulationPanel,BoxLayout.LINE_AXIS));
        simulationPanel.add(board);
        initButtons();
        simulation.start();

    }

    private void initButtons(){
        saveBtn.addActionListener(new SaveParticlesActionListener());
        startStopBtn.addActionListener(new StopStartActionListener());
        loadBtn.addActionListener(new LoadParticlesActionListener());
    }

    private class LoadParticlesActionListener implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            JFileChooser c = new JFileChooser(MainView.class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("out/production/ParticleSymulator", "examples"));
            // Demonstrate "Open" dialog:
            int rVal = c.showOpenDialog(MainView.this);
            if (rVal == JFileChooser.APPROVE_OPTION) {
                DataLoader dl = new DataLoader(c.getSelectedFile().getPath());
                repo.loadStates(dl.loadData());
                start();
            }

        }
    }


    private void start(){
        if( !isSimulateRun ) {
            simulation.start();
            startStopBtn.setText("Stop");
            isSimulateRun = !isSimulateRun;
        }
    }

    private void stop(){
        if( isSimulateRun ) {
            simulation.stop();
            startStopBtn.setText("Start");
            isSimulateRun = !isSimulateRun;
        }
    }

    private class SaveParticlesActionListener implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            JFileChooser c = new JFileChooser(MainView.class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("out/production/ParticleSymulator", "examples"));
            // Demonstrate "Save" dialog:
            int rVal = c.showSaveDialog(MainView.this);
            if (rVal == JFileChooser.APPROVE_OPTION) {
                System.out.println(c.getSelectedFile().getPath());
                DataSaver ds = new DataSaver(c.getSelectedFile().getPath());
                ds.saveData(repo.getStatesList());

            }

        }
    }

    private class StopStartActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(isSimulateRun)
                stop();
            else
                start();

        }
    }


    public JPanel getView(){
        return mainPanel;
    }

}
