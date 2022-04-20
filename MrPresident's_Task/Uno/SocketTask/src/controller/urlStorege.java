package controller;

public enum urlStorege
{
	userCkeck("userCheck"), jmMain("jmMain"), save("save"), unoMain("unoMain"), hhjMain("hhjMain"), cmhMain("cmhMain"), index("index");
	private final String value;
	private final String PACK_PATH = "controller.main.";
	urlStorege(String value)
	{
		this.value = value;
	}
	public String getValue()
	{
		return this.PACK_PATH + this.value;
	}
}
