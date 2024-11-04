package attm5;

import javax.swing.*;

public class Uno {
    public static void main(String[] args) {
        
    	JFrame frame = new JFrame("UNO Game");
        panelManager manager = new panelManager();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1400, 700);
        frame.setLocationRelativeTo(null);
        
        //call panelManager
        frame.add(manager);  
        
        frame.setVisible(true);

    }
}
