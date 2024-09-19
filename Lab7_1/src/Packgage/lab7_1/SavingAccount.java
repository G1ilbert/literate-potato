package Packgage.lab7_1;

public class SavingAccount extends BaseAccount {

	private DebitCard card;
	
	public SavingAccount(FixedSalary a) {
		super(0);
		this.card = new DebitCard(a.getssn());
		a.setCard(card);
	}
	public  boolean deposit(double method)
	{
		return true;
	}
	public boolean withdraw(int money)
	{
		return true;
	}
}
