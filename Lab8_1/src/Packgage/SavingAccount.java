package Packgage;

public class SavingAccount extends BaseAccount{
	
	private DebitCard card;
	
	public SavingAccount(FixedSalary A) {
		super(0);
		this.card = new DebitCard(A.getssn());		
		A.setCard(card);
	}
	
	public boolean deposit(double i) {
		if(i > 0) {
			balance += i;
			return true;
		}else
			return false;
	}
	
	public boolean withdraw(double o) {
		if(balance >= o) {
			balance -= o;
			return true;
		}else
			return false;
	}
	
	public class DebitCard extends Card {
		
		private double discount;
		
		public DebitCard(String ssn) {
			super(ssn);
			this.type = "visa";
			this.discount = 2.5;
			
		}
		
		public String type() {
			return (this.type);
		}
		
		public double discount() {
			return this.discount;
		}

		public String getSsn() {
			return ssn;
		}

		public void setSsn(String ssn) {
			this.ssn = ssn;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public double getDiscount() {
			return discount;
		}

		public void setDiscount(double discount) {
			this.discount = discount;
		}
		
		

	}

}
