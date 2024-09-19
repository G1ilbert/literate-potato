package Packgage;

public class BallA extends Ball implements RollAble{
	
	public BallA(String treadmark)
	{
		super(treadmark);
	}
	public void inflate(double volumn)
	{
		System.out.println(this.treadMark + "'s ball is inflated "+volumn+" cu.ft");
	}
	public void roll()
	{
		System.out.println(this.treadMark + " rolls rather smoothly.");
	}
	public String toString()
	{
		return this.treadMark + " is a treaMark of BallA";
	}
}

