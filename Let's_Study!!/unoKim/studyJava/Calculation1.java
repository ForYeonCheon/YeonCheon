package unoKim.studyJava;

abstract class Calc1
{
	int a;
	int b;
	abstract void answer();
	void setData(int m, int n)
	{
		this.a = m;
		this.b = n;
	}
}
class Plus extends Calc1
{
	@Override
	void answer()
	{
		// TODO Auto-generated method stub
		System.out.println(a + "+" + b + "=" + (a + b));
	}
}
public class Calculation1
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Plus ob = new Plus();
		ob.setData(34, 12);
		ob.answer();
	}

}
