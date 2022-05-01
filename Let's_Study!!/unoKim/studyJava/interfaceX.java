package unoKim.studyJava;

interface Apple
{
	public final int a = 1;
	public abstract void f();
}
interface Bear
{
	public final int b = 2;
	public abstract void g();
}
interface Candy
{
	public final int c = 3;
	public abstract void h();
}
interface X extends Apple, Bear, Candy
{
	public final int d = 4;
	public abstract void i();
}
class CX implements X
{
	@Override
	public void f()
	{
		// TODO Auto-generated method stub
		System.out.println("Interface Apple's f, a = " + a);
	}
	@Override
	public void g()
	{
		System.out.println("Interface Bear's g, b = " + b);
	}
	@Override
	public void h()
	{
		System.out.println("Interface Candy's h, c = " + c);
	}
	@Override
	public void i()
	{
		System.out.println("Interface X's i, d = " + d);
	}
}
public class interfaceX
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		CX ox = new CX();
		ox.f();
		ox.g();
		ox.h();
		ox.i();
	}

}
