package Packgage1;

import javax.swing.*;
import java.awt.*;

public class numberSelect extends JPanel {
    
	private static final long serialVersionUID = 1L;
	private JComboBox<Integer> playerCountComboBox;
    private JButton confirmButton;
    private panelManager manager; 
    private Image backgroundImage;

    public numberSelect(panelManager manager) {
        this.manager = manager;
        backgroundImage = new ImageIcon(getClass().getResource("/img/background/Bg5.png")).getImage();
        //backgroundImage = new ImageIcon("img\\background\\Bg2.png").getImage();
        
        setBackground(Color.decode("#39374b"));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        playerCountComboBox = new JComboBox<>(new Integer[]{1, 2, 3, 4});
        playerCountComboBox.setBackground(Color.WHITE);
        playerCountComboBox.setForeground(Color.BLACK); 

        confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(e -> confirmSelection());

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(new JLabel("Select number of players: "), gbc);

        gbc.gridy = 1;
        add(playerCountComboBox, gbc);

        gbc.gridy = 2;
        add(confirmButton, gbc);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }

    private void confirmSelection() {
        int numPlayers = (int) playerCountComboBox.getSelectedItem();
        manager.showSelectPanel(numPlayers); 
    }
}
