package Packgage;

public class InventoryCart {

	private int itemlimit;
	private int count;
	private int last;
	private Product[] products;
	
	public InventoryCart (int itemlimit) {
		this.itemlimit = itemlimit;
		this.products = new Product[itemlimit];
		this.count = 0;
	}
	
	public void add (Product p) {
			boolean check = true;
			for(Product prod : products) {
				if(prod == null) {
					break;
				}
				if(prod.equals(p)) {
					check = false;
					prod.changePrice(p.getPrice());
					prod.changeTotal();
				}
			}
			if(check) {
				products[count] = p;
				products[count].changeTotal();
				count++;
				last = count;
			}
	}
	
	public Product getProduct () {
		if(this.last >= 0) {
			Product returnProd = this.products[this.last];
			this.products[this.last] = null;
			this.last--;
			this.count = this.last;
			
			return returnProd;
		}
		return null;
	}
	
	public Product[] getAllProduct () {
		Product[] returnProds = this.products;
		this.products = new Product[this.itemlimit];
		
		return returnProds;
	}
}
