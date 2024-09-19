package Packgage;

public class Sugar extends Product{
	
	public Sugar(int prize)
	{
		super(prize);
		super.name = "Sugar";
		super.unit = "Gram";
	}
	public void setVolumn(int volumn) {
		super.total = volumn;
	}
}