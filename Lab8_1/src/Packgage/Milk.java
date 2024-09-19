package Packgage;

public class Milk extends Product{
	
	public Milk(int prize)
	{
		super(prize);
		super.name = "Milk";
		super.unit = "CC";
	}
	public void setVolumn(int volumn) {
		super.total = volumn;
	}
}
