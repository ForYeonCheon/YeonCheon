package Uno.ReadXml;

import Uno.ReadXml.controller.GetXml;

public class starter {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		starter starter = new starter();

		String id = null;
		String password = null;
		if (starter.checkUser(id, password)) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}
	}

	boolean checkUser(String id, String passWord) {
		GetXml getXml = new GetXml();
		id = "koria189";
		passWord = "test1234";
		if (getXml.getUserInfo().containsKey(id)) {
			System.out.println("user id : " + id);
			if (getXml.getUserInfo().get(id).get("password").equals(passWord)) {
				System.out.println("password conform : agreement");
			}
			return true;
		}
		return false;
	}
}
