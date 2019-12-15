import javax.swing.*;

public class ViewManager {

    private static  ViewManager instace = null;
    private static JFrame mainFrame = null;

    private ViewManager(){
        mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    public static ViewManager getManager() {
        if( instace == null ) {
            instace = new ViewManager();
        }
        return instace;
    }

    public void setView(JPanel panel, String title  ) {
        mainFrame.setContentPane( panel );
        mainFrame.setTitle( title );
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);

    }

}