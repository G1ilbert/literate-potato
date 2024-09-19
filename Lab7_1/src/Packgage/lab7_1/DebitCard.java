package Packgage.lab7_1;

public class DebitCard extends Card{
	
	private double discount;
	public DebitCard(String ssn)
	{
		super(ssn);
		this.type = "visa";
		this.discount = 2.5;
	}

	@Override
	public String type() {
		// TODO Auto-generated method stub
		return this.type;
	}

	@Override
	public double discount() {
		// TODO Auto-generated method stub
		return this.discount;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	public String getSsn() {
		return ssn;
	}
	
}
