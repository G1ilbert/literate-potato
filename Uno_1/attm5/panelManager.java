package attm5;

import javax.swing.*;
import java.awt.*;

public class panelManager extends JPanel {
	
    private CardLayout cardLayout;
    private JPanel mainPanel;
    
    private int status;
    private String currentcolor;
    
//------------------------------------------------------------------------------------------
    
    private gameLogic g;
    private GamePanel gamePanel;
    private selectPanel selectPanel;
    private numberSelect numberSelectPanel;
    private ColorChoosePanel colorChoosePanel;
    private winPanel w;
    private rulePanel r;
    private cardSetPanel c;
    
 //-----------------------------------------------------------------------------------------

    public panelManager() {
    	
    	//panel center
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        g = new gameLogic(); 
        
        colorChoosePanel = new ColorChoosePanel(this);
        numberSelectPanel = new numberSelect(this);
        selectPanel = new selectPanel(this, g);
        c = new cardSetPanel(this);
        r = new rulePanel(this);

        mainPanel.add(numberSelectPanel, "Num"); 
        mainPanel.add(selectPanel, "Select");   
        mainPanel.add(new StartPanel(this), "Start"); 
        mainPanel.add(colorChoosePanel, "ColorChoose");

        mainPanel.add(c, "Set");  
        mainPanel.add(r, "Rule");  
        
        setLayout(new BorderLayout());  
        add(mainPanel, BorderLayout.CENTER);
     

        showPanel("Start");
    }

    public void showPanel(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }

    public void showSelectPanel(int numPlayers) {
        selectPanel.setNumPlayers(numPlayers); 
        showPanel("Select"); 
    }

    public void showGame() {
        if (gamePanel == null) {
            gamePanel = new GamePanel(this, g);
            mainPanel.add(gamePanel, "Game");
        }
        showPanel("Game");
    }

    public void setStatus(int x) {
        this.status = x;

        if (status == 1) 
            showGame();
        else if (status == 2) 
        	showColor(); 
        else if (status == 3) 
            showPanel("Num"); 
    	else if (status == 4) 
    		showPanel("Set"); 
    	else if (status == 5) 
            showPanel("Rule"); 
    
    }

    public void showColor() {
        cardLayout.show(mainPanel, "ColorChoose");
    }

    public void setColor(String color) {
        this.currentcolor = color;
        System.out.println("Selected color: " + color);
        g.setColor(color); 
        setStatus(1); 
        
        if (gamePanel != null) {
            gamePanel.wild(color); 
        }
        
    }

    public void putPlayer(String name, String profile) {
        System.out.println("Adding player: " + name);
        g.select(name, profile); 
    }

    public void winstatus(String name,String img){
    	w = new winPanel(name, img);
    	mainPanel.add(w,"win");
    	showPanel("win"); 	
    }
   
}
