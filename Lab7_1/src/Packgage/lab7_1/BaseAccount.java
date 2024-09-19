package Packgage.lab7_1;

public abstract class BaseAccount implements Withdrawable{
	
	protected double balance;

	
	public BaseAccount(double balance) {
		this.balance = balance;
	}


	public abstract boolean deposit(double method);
	
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
