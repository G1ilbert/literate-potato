package Packgage;

public abstract class BaseAccount implements Withdrawable{
	protected double balance;
	
	public BaseAccount(double b) {
		this.balance = b;
	}
	
	public abstract boolean deposit(double amount);
	
	public boolean withdraw(double amount) {
		if(balance > amount) {
			balance -= amount;
			return true;
		}else
			return false;
	}


}
