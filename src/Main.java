import javax.swing.*;
import java.awt.*;


public class Main {

    public static void main(String[] args) {
        ViewManager vm = ViewManager.getManager();
        vm.setView(new MainView().getView(), "Symulacja");
    }
}
