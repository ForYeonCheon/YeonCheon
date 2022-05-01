package unoKim.studyJava;
class Purse
{
	static int money = 0;
	void printMoney(int in, int out)
	{
		money = money + in - out;
		if (money < 0)
		{
			System.out.println("출금을 " + out + "원 만큼 합니다.");
			System.out.println((-1 * money) + "원이 부족합니다.");
		}
		else
		{
			System.out.println("입금을 " + in + "원 만큼 합니다.");
			System.out.println("출금을 " + out + "원 만큼 합니다.");
			System.out.println("잔금은 " + money + "원 입니다.");
		}
	}
}

public class Shopping
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Purse store1 = new Purse();
		Purse store2 = new Purse();
		store1.printMoney(1000, 100);
		store2.printMoney(0, 200);
		store2.printMoney(0, 800);
	}

}
