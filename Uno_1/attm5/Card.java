package attm5;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Card implements Effect{

	private int value;
	private int type;
	private String color;
	private ImageIcon front_card; 
	private ImageIcon back_card;
	private String effect;
	
	public Card(int val,int t,String color){
		this.value = val;
		this.type = t;
		this.color = color;
		ImageIcon f = null;
		
		f = new ImageIcon("img\\card\\"+ color + "_card\\" + val + ".png"); 
		
		ImageIcon b = new ImageIcon("img\\card\\back\\back.png"); 
		
		this.front_card = f;
		this.back_card = b;
	}
	
	public void setEffect(){
		if(type == 0){
			this.effect = "no";
		} 
		else if(type == 1){
			if(value == 10) this.effect = "draw 2";
			if(value == 11) this.effect = "skip";
			if(value == 12) this.effect = "reverse";
		}
		else if(type == 2){
			if(value == 13) this.effect = "draw 4";
			if(value == 14) this.effect = "setColor";
		}
	}
	
	public String getEffect() {
		return effect;
	}

	public ImageIcon getFront_card() {
		return front_card;
	}

	public ImageIcon getBack_card() {
		return back_card;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	private ImageIcon resizeImage(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }
	
	public void resizeCardImages(int width, int height) {
	    this.front_card = resizeImage(this.front_card, width, height);
	    this.back_card = resizeImage(this.back_card, width, height);
	}
	
}
