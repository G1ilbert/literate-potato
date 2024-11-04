package attm5;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Desk {
    private Stack<Card> cardset;
    private String[] color = {"blue", "red", "yellow", "green"};

    public void addCard(int x, int y, String color) {
        
    	Card newCard = new Card(x,y,color);
    	newCard.setEffect();
    	cardset.add(newCard);
        
    }

    public void setDesk() {
        this.cardset = new Stack<Card>();

        for (String c : color) {
            addCard(0, 0, c);
        }

        for (int n = 1; n <= 9; n++) {
            for (String c : color) {
                addCard(n, 0, c);
                addCard(n, 0, c);
            }
        }

        for (int n = 10; n <= 12; n++) {
            for (String c : color) {
                addCard(n, 1, c);
                addCard(n, 1, c);
            }
        }

        for (int j = 0; j < 4; j++) {
            addCard(13, 2, "wild");
        }
        for (int j = 0; j < 4; j++) {
            addCard(14, 2, "wild");
        }
    }

    public void shuffle()
    {
    	Collections.shuffle(cardset);
    }

    public Stack<Card> getDesk() {
        return cardset;
    }


    
    public Card drawCard() {
        if (cardset.isEmpty()) {
            return null;
        }
        return cardset.pop();
    }

    public int getSize() {
        return cardset.size();
    }
    
    public void setNewDesk(List<Card> played){

    	for(Card c : played){
    		cardset.add(c);
    	}
    }
}