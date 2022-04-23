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
			System.out.print("If you want to go out this program, Please enter the \":q\" word\n");
			System.out.print("Input User Id : ");
			id = sc.nextLine();
			programOut(id);
			System.out.print("\nInput User Password : ");
			password = sc.nextLine();
			programOut(password);
			if (userSO.checkUser(id, password)) {
				loginFlag = !loginFlag;
			}
		}
		sc.close();
	}

	private void programOut(String input) {
		if (input.equalsIgnoreCase(":q")) {
			System.out.println("Program is out...");
			System.exit(0);
		}
	}
}
