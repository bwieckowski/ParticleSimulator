package DataManagment;

import Simulation.Memento.State;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class DataLoader {
    private String filename;

    public DataLoader(String filename) {
        this.filename = filename;
    }

    public List<State> loadData() {
        FileInputStream fis;
        ObjectInputStream ois;
        List<State> movableDataList = null;
        try {
            fis = new FileInputStream(filename);
            ois = new ObjectInputStream(fis);
            movableDataList = (List<State>) ois.readObject();
            ois.close();
        } catch (IOException e) {
            System.out.println("File with saved data doesn't exist.");
        } catch (Exception e ) {
            e.printStackTrace();
        }
        return movableDataList;
    }
}
