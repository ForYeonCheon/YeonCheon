package Uno.ReadXml;

import Uno.ReadXml.controller.GetXml;
import Uno.ReadXml.controller.method.Login;

public class starter {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		/* 로그인 */
		Login.doLogin();
		GetXml xml = new GetXml();
		xml.getUserInfo();
	}
}
