package Uno.ReadXml.controller.BO;

import Uno.ReadXml.controller.GetXml;

public class LoginBO {

	public boolean checkUser(String id, String passWord) {
		GetXml getXml = new GetXml();
		if (this.checkId(getXml, id))
			if (this.checkPassword(getXml, id, passWord))
				return true;
		return false;
	}

	private boolean checkId(GetXml getXml, String id) {
		if (getXml.getUserInfo().containsKey(id)) {
			System.out.println("user id : " + id);
			return true;
		}
		System.out.println("로그인 실패");
		return false;
	}

	private boolean checkPassword(GetXml getXml, String id, String password) {
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
