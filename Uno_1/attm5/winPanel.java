package attm5;

import javax.swing.*;
import java.awt.*;

public class winPanel extends JPanel {
    private JLabel characterImageLabel;
    private JLabel playerLabel;
    private Image backgroundImage;

    public winPanel(String name, String img) {
        backgroundImage = new ImageIcon("img\\background\\Bg2.png").getImage();
        
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        playerLabel = new JLabel(name+" wins!!!");
        playerLabel.setForeground(Color.WHITE);
        playerLabel.setFont(new Font("Arial", Font.BOLD, 30)); 

        gbc.anchor = GridBagConstraints.CENTER; 
        add(playerLabel, gbc);

        characterImageLabel = new JLabel(resizeImage(new ImageIcon(img), 250, 300));
        gbc.gridy = 1; 
        add(characterImageLabel, gbc);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this); 
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
