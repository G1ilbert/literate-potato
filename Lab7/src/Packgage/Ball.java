package Packgage;

public abstract class Ball {
	
	protected String treadMark;
	
	public Ball(String treadMark)
	{
		this.treadMark = treadMark;
	}
	public abstract void inflate(double volumn);
}
