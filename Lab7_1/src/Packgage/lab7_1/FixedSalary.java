package Packgage.lab7_1;

public class FixedSalary extends Employees {
	protected double Msalary;
	private DebitCard DebitCard;
	
	
	public FixedSalary(String f, String l, String ssn, double sa) {
		super(f,l,ssn);
		this.Msalary = sa;
		
	}
	
	public double earnings() {
		return Msalary;
	}
	
	public String toString() {
		return String.format("%s %s\nsocial security number: %s\nmonthly salary $%.2f", 
								firstName, lastName, securityNumber, Msalary);
		}
	
	public DebitCard getCard() {
		return DebitCard;
	}

	public void setCard(DebitCard card) {
		DebitCard = card;
	}
}
