package Uno.ReadXml;

import Uno.ReadXml.controller.SO.UsertrtmSO;

public class starter {

	static String id = "koria189";
	static String password = "test1234";

	public static void main(String[] args) throws Exception {
		UsertrtmSO userSO = new UsertrtmSO();
		// TODO Auto-generated method stub
		if (userSO.Login(id, password)) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}
	}
}
