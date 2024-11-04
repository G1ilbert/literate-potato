package attm5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ColorChoosePanel extends JPanel {
    private JLabel cardImageLabel; 
    private JPanel buttonPanel;
    private panelManager p;

    public ColorChoosePanel(panelManager manager) {
        this.p = manager;
        
        setPreferredSize(new Dimension(800, 600)); 
        setLayout(new BorderLayout());
        setOpaque(true); 

        cardImageLabel = new JLabel();
        cardImageLabel.setVerticalAlignment(JLabel.CENTER);
        cardImageLabel.setHorizontalAlignment(JLabel.CENTER);
        add(cardImageLabel, BorderLayout.CENTER);

        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.decode("#39374b"));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20)); 
        createCardButton("red", "img\\card\\red_card\\Blank_red.png", manager);
        createCardButton("green", "img\\card\\green_card\\Blank_green.png", manager);
        createCardButton("blue", "img\\card\\blue_card\\Blank_blue.png", manager);
        createCardButton("yellow", "img\\card\\yellow_card\\Blank_yellow.png", manager);

        //panel doesn't stretch
        buttonPanel.setPreferredSize(new Dimension(1800, 1500));

        buttonPanel.setBorder(BorderFactory.createEmptyBorder(190, 0, 20, 0)); 

        add(buttonPanel, BorderLayout.NORTH); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon backgroundImage = new ImageIcon("");
        g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this); 
    }

    private void createCardButton(String colorName, String imagePath, panelManager manager) {
        JButton cardButton = new JButton();

        ImageIcon originalIcon = new ImageIcon(imagePath);
        int desiredWidth = 200; 
        int desiredHeight = 270; 
        Image scaledImage = originalIcon.getImage().getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        cardButton.setIcon(scaledIcon);
        cardButton.setPreferredSize(new Dimension(desiredWidth, desiredHeight + 15));
        cardButton.setBorderPainted(false); 
        cardButton.setContentAreaFilled(false); 
        cardButton.setToolTipText("Select " + colorName + " color"); 
        
        cardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(colorName + " selected");
                p.setColor(colorName);
            }
        });
        
        cardButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                cardButton.setBounds(cardButton.getX(), cardButton.getY() - 10, cardButton.getWidth(), cardButton.getHeight()); // Move up by 10 pixels
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cardButton.setBounds(cardButton.getX(), cardButton.getY() + 10, cardButton.getWidth(), cardButton.getHeight()); // Move back down by 10 pixels
            }
        });
        
        buttonPanel.add(cardButton);
    }
}
