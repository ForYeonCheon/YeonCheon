package unoKim.studyJava;
class Study
{
	String name;
	String teacher;
	void printmsg()
	{
		System.out.println("과목 : " + name);
		System.out.println("교수 : " + teacher);
	}
}
class Sub_java extends Study
{
	int credit;
	String room;
	void printJV()
	{
		printmsg();
		System.out.println("학점 : " + credit);
		System.out.println("강의실 : " + room);
	}
}
public class Study_java
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Sub_java Sub_java = new Sub_java();
		Sub_java.name = "자바";
		Sub_java.room = "123";
		Sub_java.teacher = "한사대";
		Sub_java.credit = 3;
		Sub_java.printJV();

	}

}
