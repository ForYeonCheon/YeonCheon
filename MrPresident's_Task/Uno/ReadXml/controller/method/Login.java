package Uno.ReadXml.controller.method;

import java.util.Scanner;

import Uno.ReadXml.controller.SO.UsertrtmSO;

public class Login {
	static String id;
	static String password;
	static boolean loginFlag = true;

	public static void setUserId(String id) {
		Login.id = id;
	}

	public static String getUserId() {
		return Login.id;
	}

	// private static으로 선언
	private static Login instance = new Login();

	// 인스턴스 리턴
	public static Login doLogin() {
		return instance;
	}

	private Login() {
		UsertrtmSO userSO = new UsertrtmSO();
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
		sc.close();
	}
}
