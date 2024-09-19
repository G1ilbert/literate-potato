package Packgage;

public class BallC extends BallA{
	
	public BallC(String treadmark)
	{
		super(treadmark);
	}
	public void inflate(double volumn)
	{
		System.out.println(this.treadMark + "'s ball is inflated "+volumn+" cu.ft");
	}
	public void roll()
	{
		System.out.println(this.treadMark + " rolls very smoothly.");
	}
	public String toString()
	{
		return this.treadMark + " is a treaMark of BallC";
	}
}
