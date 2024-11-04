package Packgage1;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class StartPanel extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private panelManager p; 
    private String hoveredOption = null; 
    private Image backgroundImage;

    public StartPanel(panelManager manager) {
        this.p = manager;
        setBackground(Color.decode("#39374b"));
        setLayout(null);
        addMouseListener(); 
        addMouseMotionListener(); 
       
        backgroundImage = new ImageIcon(getClass().getResource("/img/background/Bg5.png")).getImage();
        


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 100));
        String title = "UNO";
        
        int height = getHeight();
        
        drawCenteredString(g, title, (int)(height*0.25)); 

        g.setFont(new Font("Arial", Font.BOLD, 50));
        String startOption = "Start";
        String ruleOption = "Rule";
        String cardSetOption = "Card Set";
        String quitOption = "Quit";

        int startY = height;
        drawOption(g, startOption, (int)(startY*0.40));
        drawOption(g, cardSetOption, (int)(startY*0.55));
        drawOption(g, ruleOption, (int)(startY*0.70));
        drawOption(g, quitOption, (int)(startY*0.85));
    }

    private void drawOption(Graphics g, String text, int y) {
        
        if (text.equals(hoveredOption)) {
            g.setColor(Color.yellow); 
        } else {
            g.setColor(Color.white);
        }

        drawCenteredString(g, text, y);
    }

    private void drawCenteredString(Graphics g, String text, int y) {
        FontMetrics fm = g.getFontMetrics();
        int textWidth = fm.stringWidth(text);
        
        g.drawString(text, (getWidth() - textWidth) / 2, y);
        
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    private void addMouseListener() {
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int mouseY = evt.getY();
                int mouseX = evt.getX();
                
                
                int width = getWidth();
                int height = getHeight();

                // Check which option was clicked based on updated bounds
                if (mouseY >= height*0.35 && mouseY <= height*0.4 && mouseX >=width*0.45 && mouseX <=width*0.55) {
                    System.out.println("Start selected");
                    p.setStatus(3); 
                } else if (mouseY >= height*0.5  && mouseY <= height*0.55 && mouseX >=width*0.42 && mouseX <=width*0.58) {
                    System.out.println("Card Set selected");
                    p.setStatus(4);
                } else if (mouseY >= height*0.6 && mouseY <= height*0.7 && mouseX >=width*0.45 && mouseX <=width*0.55) {
                    System.out.println("Rule selected");
                    p.setStatus(5);
                } else if (mouseY >= height*0.78 && mouseY <= height*0.85 && mouseX >=width*0.45 && mouseX <=width*0.55) {
                    System.out.println("Quit selected");
                    System.exit(0);
                }
            }
        });
    }

    private void addMouseMotionListener() {
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                int mouseY = evt.getY();
                int mouseX = evt.getX();                
                
                int width = getWidth();
                int height = getHeight();                               

                if (mouseY >= height*0.35 && mouseY <= height*0.4 && mouseX >=width*0.45 && mouseX <=width*0.55) {
                    hoveredOption = "Start";
                } else if (mouseY >= height*0.5  && mouseY <= height*0.55 && mouseX >=width*0.42 && mouseX <=width*0.58) {
                    hoveredOption = "Card Set";
                } else if (mouseY >= height*0.6 && mouseY <= height*0.7 && mouseX >=width*0.45 && mouseX <=width*0.55) {
                    hoveredOption = "Rule";
                } else if (mouseY >= height*0.78 && mouseY <= height*0.85 && mouseX >=width*0.45 && mouseX <=width*0.55) {
                    hoveredOption = "Quit";
                } else {
                    hoveredOption = null; 
                }

                repaint();
            }
        });
    }
}