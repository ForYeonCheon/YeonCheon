package Uno.ReadXml.controller.SO;

import Uno.ReadXml.controller.BO.LoginBO;

public class UsertrtmSO
{
	final LoginBO loginBO;

	public UsertrtmSO()
	{
		loginBO = new LoginBO();
	}

	public boolean checkUser(String id, String password)
	{
		return loginBO.checkUser(id, password);
	}
}
