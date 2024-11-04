package attm5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class selectPanel extends JPanel {
    private JLabel characterImageLabel;
    private JTextField nameField;
    private JLabel playerLabel;
    private JButton confirmButton;
    private String[] characterProfiles = {
        "img/profile/Yunji.png",
        "img/profile/Jelwarin.png",
        "img/profile/Jean.png",
        "img/profile/Piin.png"
    };

    private panelManager p;
    private gameLogic g;
    
    private int currentIndex = 0;
    private int currentPlayer = 1;
    private int numPlayers;
    private int x = 250, y = 300;
    
    private ArrayList<String> playerNamesList = new ArrayList<>();
    private ArrayList<String> playerProfilesList = new ArrayList<>();
    private Image backgroundImage;

    public selectPanel(panelManager p, gameLogic g) {
        this.p = p;
        this.g = g;

        backgroundImage = new ImageIcon("img\\background\\Bg2.png").getImage();
        
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        playerLabel = new JLabel();
        playerLabel.setForeground(Color.WHITE);
        updatePlayerLabel();

        JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        imagePanel.setOpaque(false);

        characterImageLabel = new JLabel(resizeImage(new ImageIcon(characterProfiles[currentIndex]), x, y));
        JLabel leftArrow = new JLabel("<");
        JLabel rightArrow = new JLabel(">");
        Font arrowFont = new Font("Arial", Font.BOLD, 40);
        leftArrow.setFont(arrowFont);
        leftArrow.setForeground(Color.WHITE);
        rightArrow.setFont(arrowFont);
        rightArrow.setForeground(Color.WHITE);

        leftArrow.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currentIndex = (currentIndex - 1 + characterProfiles.length) % characterProfiles.length;
                characterImageLabel.setIcon(resizeImage(new ImageIcon(characterProfiles[currentIndex]), x, y));
            }
        });

        rightArrow.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currentIndex = (currentIndex + 1) % characterProfiles.length;
                characterImageLabel.setIcon(resizeImage(new ImageIcon(characterProfiles[currentIndex]), x, y));
            }
        });

        imagePanel.add(leftArrow);
        imagePanel.add(characterImageLabel);
        imagePanel.add(rightArrow);

        nameField = new JTextField("", 8);
        nameField.setHorizontalAlignment(JTextField.CENTER);
        nameField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        nameField.setBackground(Color.decode("#1f1e28"));
        nameField.setForeground(Color.WHITE);
        nameField.setFont(new Font("Arial", Font.BOLD, 30));
        nameField.setPreferredSize(new Dimension(190, 50));

        confirmButton = new JButton("Confirm");
        confirmButton.setBorder(BorderFactory.createEmptyBorder());
        confirmButton.setPreferredSize(new Dimension(100, 40));
        confirmButton.setBackground(Color.decode("#FFFFFF"));
        confirmButton.setForeground(Color.black);
        confirmButton.addActionListener(e -> confirmSelection());

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(playerLabel, gbc);
        gbc.gridy = 1;
        add(imagePanel, gbc);
        gbc.gridy = 2;
        add(nameField, gbc);
        gbc.gridy = 3;
        add(confirmButton, gbc);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this); 
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
        updatePlayerLabel();
    }

    private void updatePlayerLabel() {
        playerLabel.setText("Player " + currentPlayer + " - Select your character");
    }

    private void confirmSelection() {
    	
        String name = nameField.getText().trim();
        
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "", "Invalid Name", JOptionPane.WARNING_MESSAGE);
            return;
        }

        g.select(name, characterProfiles[currentIndex]);
        
        proceedToNextPlayer();
    }

    private void proceedToNextPlayer() {
        if (currentPlayer < numPlayers) {
        	
            currentPlayer++;
            updatePlayerLabel();
            
            nameField.setText("");
            
            currentIndex = 0;
            
            characterImageLabel.setIcon(resizeImage(new ImageIcon(characterProfiles[currentIndex]), x, y));
            
        } else {
        	
            p.setStatus(1);
            
        }
    }
    
    private ImageIcon resizeImage(ImageIcon image, int width, int height) {
        if (image != null && image.getImage() != null) {
            Image img = image.getImage();
            Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(newImg);
        }
        return null;
    }
}
