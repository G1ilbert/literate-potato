package Packgage1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cardSetPanel extends JPanel {

    private JLabel characterImageLabel;
    private JLabel playerLabel;
    private Image backgroundImage;
    private JButton exitButton;

    public cardSetPanel(panelManager p) {
        //backgroundImage = new ImageIcon("img\\background\\Bg3.png").getImage();
        backgroundImage = new ImageIcon(getClass().getResource("/img/background/Bg3.png")).getImage();

        setLayout(null);

        exitButton = new JButton("X");
        exitButton.setFont(new Font("Arial", Font.BOLD, 12));
        exitButton.setBounds(getWidth() - 100, 10, 90, 30); 
        exitButton.setForeground(Color.WHITE); 
        exitButton.setBackground(Color.RED); 
        exitButton.setBorderPainted(false); 
        
        add(exitButton);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                System.out.println("Exiting to main");
                p.showPanel("Start");
                
            }
        });

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                exitButton.setBounds(getWidth() - 100, 10, 90, 30); 
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}
