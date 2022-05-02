package unoKim.studyJava;

class ClassX
{
	int m = -10;
	ClassX()
	{
		System.out.println("super class X ");
	}
}
class ClassY extends ClassX
{
	int n = 10;
	ClassY()
	{
		System.out.println("sub class Y ");
	}
}
public class userNewSub
{

	public static void main(String[] args)
	{
		System.out.println("ClassX ox1 = new ClassX();");
		ClassX x1 = new ClassX();
		System.out.println("ClassY y =  new ClassY();");
		ClassX x2 = new ClassY();
		System.out.println("x2.m = " + x2.m);

	}

}
