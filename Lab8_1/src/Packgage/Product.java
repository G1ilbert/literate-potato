package Packgage;

public class Product {
	
	protected String name;
	protected int price;
	protected int quantity = 0;
	protected String unit;
	protected int total;
	
	public Product(int p) {
		this.price = p;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setWeight(int v) {
		this.total = v;
	}
	
	public void changePrice(int p) {
		this.price += p;
	}
	
	public void changeTotal() {
		this.quantity++;
	}
	
	public boolean equals(Object obj) {

		if(this == obj) return true;
		if((obj == null) || !(obj instanceof Product)) return false;
		
		Product prod = (Product)obj;
		
		return this.price == prod.price && 
				this.name == prod.name && 
				this.unit == prod.unit;
	}
	
	public String toString() {
		return quantity +" x "+name+"\t"+total+"\t"+unit+"\t"+price;
	}
}
