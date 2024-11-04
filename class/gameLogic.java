package Packgage1;

import java.util.ArrayList;
import java.util.List;

public class gameLogic {
    private Desk desk;
    private String[] directions = {"left", "right"};
    private int directionIndex = 1;
    private boolean afterSet = false;
    private String nextPlayer = "right";
    private Card lastPlayedCard;
    private List<Player> players = new ArrayList<>();
    private int currentPlayerIndex = 0;
    private List<Card> played = new ArrayList<>();

    public void select(String name, String img) {
        players.add(new Player(name, img));
    }

    public void drawAll(int count) {
        for (int i = 0; i < count; i++) {
            for (Player player : players) {
                player.addCard(desk.drawCard());
            }
        }
    }

    public void startGame() {
        desk = new Desk();
        desk.setDesk();
        desk.shuffle();
        drawAll(7);
    }

    public boolean play(Card c) {
        if (canPlay(c)) {
            lastPlayedCard = c;
            played.add(c);
            afterSet = false;
            applyCardEffect(c);
            return true;
        } else {
            return false;
        }
    }

    public boolean canPlay(Card c) {
    	
    	
        if (lastPlayedCard == null) {
            return true; 
        }
        
        String color = lastPlayedCard.getColor();
        
        int value = lastPlayedCard.getValue();

        if (afterSet) {
        	
            return c.getColor().equals(color) || c.getColor().equals("wild_card");
        } else {
            return c.getColor().equals(color) || c.getValue() == value || c.getColor().equals("wild_card");
        }
        
    } 

    public void applyCardEffect(Card c) {
    	
    	if(lastPlayedCard != null) {
        	if(afterSet)
        	System.out.println("all");
        	else
        		System.out.println(lastPlayedCard.getColor());
        	}
        	
        	
        Player nextPlayer = players.get(nextPlayerIndex());
        switch (c.getEffect()) {
            case "skip":
                next();
                break;
            case "reverse":
                this.nextPlayer = directions[(++this.directionIndex) % 2];
                break;
            case "draw 2":
                drawCardsForPlayer(nextPlayer, 2);
                next();
                break;
            case "draw 4":
                drawCardsForPlayer(nextPlayer, 4);
                next();
                afterSet = true;
                break;
            case "setColor":
                afterSet = true;
                break;
        }
    }

    private void drawCardsForPlayer(Player player, int count) {
        for (int i = 0; i < count; i++) {
            player.addCard(desk.drawCard());
        }
    }

    public void next() {
        if (nextPlayer.equals("right")) {
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        } else {
            currentPlayerIndex = (currentPlayerIndex - 1 + players.size()) % players.size();
        }
    }

    public int nextPlayerIndex() {
        if (nextPlayer.equals("right")) {
            return (currentPlayerIndex + 1) % players.size();
        }
        return (currentPlayerIndex - 1 + players.size()) % players.size();
    }

    public void setColor(String color) {
        this.lastPlayedCard.setColor(color);
    }

    public void drawCard() {
        Player currentPlayer = players.get(currentPlayerIndex);
        currentPlayer.addCard(desk.drawCard());
    }

    public Player playingPlayer() {
    
    	if (players.isEmpty()) {
    	        System.out.println("No players available. Ensure player selection is complete.");
    	        return null;
    	}

    	else return players.get(currentPlayerIndex);
    }

    public Card lateCard() {
        return lastPlayedCard;
    }

    public void setCard(String color) {
        if (lastPlayedCard != null) {
            lastPlayedCard.setColor(color);
        }
    }
    
    public int getDeskSize() {
    	return desk.getSize();
    }
    
    public void addDesk(){
        desk.setNewDesk(played);
        desk.shuffle();
        played.clear();
    }

}
