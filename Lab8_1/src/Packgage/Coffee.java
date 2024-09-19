package Packgage;

public class Coffee extends Product{
	
	public Coffee(int prize)
	{
		super(prize);
		super.name = "Coffee";
		super.unit = "Gram";
	}
	public void setVolumn(int volumn) {
		super.total = volumn;
	}
}