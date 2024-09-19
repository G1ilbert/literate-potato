package Packgage.lab7_1;

public abstract class Card implements Withdrawable{
	
	protected double balance;
	protected String ssn;
	protected String type;
	
	public Card(String ssn)
	{
		this.ssn = ssn;
	}
	public abstract String type();

	public abstract double discount();
	
	public boolean withdraw(double amount)
	{
		if(balance >= amount)
		{
			balance -= amount;
			return true;
		}
		else
			return false;
		
	}
}
