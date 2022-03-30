package controller;

public enum urlStorege
{
	userCkeck("userCheck"), jongminMainPage("BuyerSwitch"), unoMainPage("unoMain"), hhjMainPage("RankSwitch"), cmhMainPage("DetailSwitch");
	private final String value;
	private final String PACK_PATH = "com.aPlatform.controller.service.finance.model.";
	urlStorege(String value)
	{
		this.value = value;
	}
	public String getValue()
	{
		return this.PACK_PATH + this.value;
	}
	boolean equalsIgnoreCase(String string)
	{
		// TODO Auto-generated method stub
		return false;
	}
}
