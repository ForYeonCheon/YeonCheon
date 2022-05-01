package unoKim.studyJava;
class A
{
	static int a;
}
public class CommonA
{

	@SuppressWarnings({"static-access", "unused"})
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		A a1 = new A();
		A a2 = new A();
		a1.a = 50;
		System.out.println(A.a);

	}

}
