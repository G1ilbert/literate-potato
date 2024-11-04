package Packgage1;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import java.awt.*;

public class Player {
    private List<Card> hand;
    private Image Profile; 
    private String name;
    private String p;

    public Player(String name,String Profile) {
    	this.p = Profile;
    	this.name = name;
    	this.Profile = new ImageIcon(getClass().getResource(Profile)).getImage();
        this.hand = new ArrayList<>();
    }

    public Image getProfile() {
		return Profile;
	}
    public String getStringProfile() {
		return p;
	}

	public String getName() {
		return name;
	}

	public void addCard(Card card) {
        hand.add(card);
    }

    public void removeCard(Card card) {
        hand.remove(card);
    }

    public List<Card> getHand() {
        return hand;
    }
}
