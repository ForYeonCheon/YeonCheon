package unoKim.studyJava;
class Ap
{
	int m = -10;
	void p()
	{
		System.out.println("Super class p() : ");
	}
}
class Bp extends Ap
{
	int n = 20;
	void p()
	{
		System.out.println("Sub class p() : ");
	}
	void q()
	{
		System.out.println("sub class q() : ");
	}
}
public class Sub2Super
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Ap oap = new Ap();
		Bp obp = new Bp();
		System.out.println("oap.m = " + oap.m);
		oap.p();
		obp.m = 10;
		oap = obp;
		System.out.println("oap.m = " + oap.m);
		System.out.println("obp.m = " + obp.m);
		System.out.println("obp.n = " + obp.n);
		oap.p();
	}

}
