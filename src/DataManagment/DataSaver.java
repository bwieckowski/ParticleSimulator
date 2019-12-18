package DataManagment;

import Simulation.Memento.State;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class DataSaver {
    private String filename;

    public DataSaver(String filename) {
        this.filename = filename;
    }

    public void saveData(List<State> movableDataList) {
        ObjectOutputStream oos;
        FileOutputStream fout;
        try {
            fout = new FileOutputStream(filename);
            oos = new ObjectOutputStream(fout);
            oos.writeObject(movableDataList);
            oos.close();
            System.out.println("Zapisano particle");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
