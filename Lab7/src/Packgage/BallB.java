package Packgage;

public class BallB extends BallA{
	
	public BallB(String treadmark)
	{
		super(treadmark);
	}
	public void inflate(double volumn)
	{
		System.out.println(this.treadMark + "'s ball is inflated "+volumn+" cu.ft");
	}
	public void roll()
	{
		System.out.println(this.treadMark + " rolls smoothly.");
	}
	public String toString()
	{
		return this.treadMark + " is a treaMark of BallB";
	}
}
