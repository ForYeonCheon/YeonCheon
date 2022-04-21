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
		return false;
	}

	private boolean checkPassword(GetXml getXml, String id, String password) {
		if (getXml.getUserInfo().get(id).get("password").equals(password)) {
			System.out.println("password conform : agreement");
			return true;
		}
		return false;
	}
}
