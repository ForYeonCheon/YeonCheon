package unoKim.studyJava;
class E extends Object
{
	void bye()
	{
		System.out.println("good bye");
	}
}
class J extends E
{
	void bye()
	{
		System.out.println("안녕히계세요");
	}
}
class EJ
{
	void great(E ee)
	{
		ee.bye();
	}
	void great(J jj)
	{
		jj.bye();
	}
}
public class ParamS<T>
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		E oe = new E();
		J oj = new J();
		EJ oej = new EJ();
		oej.great(oe);
		oej.great(oj);

	}

}
