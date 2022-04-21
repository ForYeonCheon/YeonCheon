package Uno.ReadXml.controller.BO;

import Uno.ReadXml.controller.GetXml;

public class LoginBO {

	private final GetXml getXml = new GetXml();

	public boolean checkUser(String id, String passWord) {
		if (this.checkId(id))
			if (this.checkPassword(id, passWord))
				return true;
		return false;
	}

	private boolean checkId(String id) {
		if (getXml.getUserInfo().containsKey(id)) {
			System.out.println("user id : " + id);
			return true;
		}
		System.out.println("로그인 실패");
		return false;
	}

	private boolean checkPassword(String id, String password) {
		if (getXml.getUserInfo().get(id).get("password").equals(password)) {
			System.out.println("password conform : agreement");
			System.out.println("로그인 성공");
			return true;
		} else {
			System.out.println("로그인 실패");
			return false;
		}
	}
}
