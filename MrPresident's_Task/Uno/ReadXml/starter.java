package Uno.ReadXml;

import java.util.Scanner;

import Uno.ReadXml.controller.SO.UsertrtmSO;

public class starter {

	static String id = "koria189";
	static String password = "test1234";
	static boolean loginFlag = true;

	public static void main(String[] args) throws Exception {
		UsertrtmSO userSO = new UsertrtmSO();
		// TODO Auto-generated method stub
		/* 로그인 */
		Scanner sc = new Scanner(System.in);
		while (loginFlag) {
			System.out.print("Input User Id : ");
			id = sc.nextLine();
			System.out.print("\nInput User Password : ");
			password = sc.nextLine();
			if (userSO.checkUser(id, password)) {
				loginFlag = !loginFlag;
			}
		}
		/* 로그인종료 */
		sc.close();
	}
}
