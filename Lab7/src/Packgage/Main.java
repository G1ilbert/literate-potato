package Packgage;

public class Main {
	//function
	public static void Test(Ball b,double volumn)
	{
		System.out.println(b);
		b.inflate(volumn);
		((BallA)b).roll();
	}

	public static void main(String[] args) {
		BallA b1 = new BallA("Zentia");
		BallA b2 = new BallB("Zapphire");
		BallA b3 = new BallC("Zenith");
		Test(b1,1.0);
		Test(b2,1.1);
		Test(b3,1.2);

	}

}
