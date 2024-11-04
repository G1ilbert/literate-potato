package attm5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Random;

public class GamePanel extends JPanel {
	
    private JPanel cardPanel;
    private JLabel cd;
    private JLayeredPane playedCardsPanel;
    private Random random = new Random();
    private JTextField jf,topText;
    private gameLogic g;
    private panelManager p;
    private int w = 1400,h=700;

    public GamePanel(panelManager p,gameLogic g) {
    	this.p = p;
    	this.g = g;

    	g.startGame();
        setLayout(new BorderLayout());
        setBackground(Color.decode("#39374b"));

        playedCardsPanel = new JLayeredPane();

        cardPanel = new JPanel();
        cardPanel.setLayout(new FlowLayout());
        cardPanel.setPreferredSize(new Dimension(800, 150));
        cardPanel.setOpaque(false); 
        cardPanel.setBackground(new Color(0, 0, 0, 0));

        cd = new JLabel();
        cd.setBounds(0, -110, 800, 500);

        jf = new JTextField();
        jf.setBounds(0, 282, 220, 30);
        jf.setFont(new Font("Arial", Font.BOLD, 22));
        jf.setHorizontalAlignment(JTextField.CENTER);
        jf.setOpaque(false);
        jf.setBackground(new Color(0, 0, 0, 0));
        jf.setBorder(BorderFactory.createEmptyBorder());
        jf.setForeground(Color.WHITE);
        
        topText = new JTextField();  
        topText.setHorizontalAlignment(JTextField.CENTER);   
        topText.setPreferredSize(new Dimension(1800, 1300));   
        topText.setForeground(Color.WHITE);                 

        topText.setOpaque(true);
        topText.setBackground(Color.decode("#1f1e28")); 
    

        topText.setBorder(BorderFactory.createEmptyBorder());
        topText.setFont(new Font("Arial", Font.BOLD, 36));   

        topText.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        topText.setBounds(550,0,400,100);

        showDeckInGUI();

        add(cd);
        add(jf);
        add(topText);
        add(playedCardsPanel);
        add(cardPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void showDeckInGUI() {
    	
        cardPanel.removeAll();
        
        Player currentPlayer = g.playingPlayer();
        
        List<Card> hand = currentPlayer.getHand();

        topText.setText(currentPlayer.getName()+ "'s Turn");
        jf.setText(String.format("%s : %d", currentPlayer.getName(), hand.size()));

        Image pf = currentPlayer.getProfile().getScaledInstance(220, 280, Image.SCALE_SMOOTH);
        
        cd.setIcon(new ImageIcon(pf));

        for (Card card : hand) {
            if (card != null) {
                addCardButton(card);
            }
        }

        cardPanel.revalidate();
        cardPanel.repaint();
    }

    private void addCardButton(Card card) {
        ImageIcon originalIcon = card.getFront_card();
        int desiredWidth = 150; 
        int desiredHeight = 210; 
        int x = g.playingPlayer().getHand().size();
        
        if(x <= 7) {
        	desiredWidth = 150; 
        	desiredHeight = 210; }
        if(x > 7) {
        	desiredWidth = 150-50; 
    		desiredHeight = 210-50;} 
        if(x > 13) {
        	desiredWidth = 150-75; 
    		desiredHeight = 210-75;} 
        if(x > 17) {
        	desiredWidth = 150-100; 
    		desiredHeight = 210-100;}
        if(x > 25) {
        	desiredWidth = 150-100-2*(x-25); 
    		desiredHeight = 210-100-2*(x-25);}
        if(x > 30) {
        	desiredWidth = 150-112; 
    		desiredHeight = 210-112;}

        Image scaledImage = originalIcon.getImage().getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);
        
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JButton cardButton = new JButton();
        cardButton.setIcon(scaledIcon);
        cardButton.setPreferredSize(new Dimension(desiredWidth, desiredHeight + 15));
        cardButton.setBorderPainted(false);
        cardButton.setContentAreaFilled(false);
        cardButton.setToolTipText("Card: " + card.getValue() + " " + card.getColor()); 
        
        cardButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                cardButton.setBounds(cardButton.getX(), cardButton.getY() - 10, cardButton.getWidth(), cardButton.getHeight()); // Move up by 10 pixels
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cardButton.setBounds(cardButton.getX(), cardButton.getY() + 10, cardButton.getWidth(), cardButton.getHeight()); // Move back down by 10 pixels
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Card clicked: " + card.getValue() + " " + card.getColor());
                addCardToPlayedPanel(card);
            }
        });

        cardPanel.add(cardButton);
    }

    private void addCardToPlayedPanel(Card cardToPlay) {
    	
        Player currentPlayer = g.playingPlayer();
        
        if(g.lateCard() != null)
        System.out.println(g.lateCard().getColor());
        
        if (g.canPlay(cardToPlay)) {
        	
        	if(cardToPlay.getColor().equals("wild"))
        		
        		p.setStatus(2);
        	
            JButton playedCardButton = new JButton() {
                private final int rotationAngle = random.nextInt(45);

                @Override
                protected void paintComponent(Graphics g) {
                    Graphics2D g2d = (Graphics2D) g.create();
                    g2d.rotate(Math.toRadians(rotationAngle), getWidth() / 2, getHeight() / 2);
                    super.paintComponent(g2d);
                    g2d.dispose();
                }
            };

            ImageIcon originalIcon = cardToPlay.getFront_card();
            int desiredWidth = 50 * 3;
            int desiredHeight = 70 * 3;
            Image scaledImage = originalIcon.getImage().getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);
            playedCardButton.setIcon(new ImageIcon(scaledImage));
            playedCardButton.setPreferredSize(new Dimension(desiredWidth, desiredHeight));
            playedCardButton.setBorderPainted(false);
            playedCardButton.setContentAreaFilled(false);

            playedCardButton.setBounds(w / 3 + w / 12, h / 4, desiredWidth + desiredWidth, desiredHeight + 60);
            playedCardsPanel.add(playedCardButton, Integer.valueOf(playedCardsPanel.getComponentCount()));

            currentPlayer.removeCard(cardToPlay);
 
            g.play(cardToPlay);

            
            List<Card> hand = currentPlayer.getHand();

            if (hand.size() == 0) {
                p.winstatus(currentPlayer.getName(), currentPlayer.getStringProfile());
            }

            g.next();

        } else {
        	
        	if(g.getDeskSize() > 0)
                g.drawCard();

        	else g.addDesk();
                
        	g.next();   
        }

        playedCardsPanel.revalidate();
        playedCardsPanel.repaint();
       
        
        showDeckInGUI();
    }

    public void setColor(String s) {
    	g.setColor(s);
    }
    
    public void wild(String color) {
    	

    	ImageIcon f = new ImageIcon("img\\card\\" + color + "_card\\Blank_" + color + ".png");

    	
    	 JButton playedCardButton = new JButton() {
             private final int rotationAngle = random.nextInt(45);

             @Override
             protected void paintComponent(Graphics g) {
                 Graphics2D g2d = (Graphics2D) g.create();
                 g2d.rotate(Math.toRadians(rotationAngle), getWidth() / 2, getHeight() / 2);
                 super.paintComponent(g2d);
                 g2d.dispose();
             }
         };

         ImageIcon originalIcon = f;
         int desiredWidth = 50 * 3;
         int desiredHeight = 70 * 3;
         Image scaledImage = originalIcon.getImage().getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);
         playedCardButton.setIcon(new ImageIcon(scaledImage));
         playedCardButton.setPreferredSize(new Dimension(desiredWidth, desiredHeight));
         playedCardButton.setBorderPainted(false);
         playedCardButton.setContentAreaFilled(false);

         playedCardButton.setBounds(w / 3 + w / 12, h / 4, desiredWidth + desiredWidth, desiredHeight + 60);
         playedCardsPanel.add(playedCardButton, Integer.valueOf(playedCardsPanel.getComponentCount()));
    	
    }
    
    public void setLogic(gameLogic g) {
    	this.g = g;
    }
}