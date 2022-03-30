package controller.main;

import controller.methodFactory;

public class cmhMain implements methodFactory
{

	@Override
	public Object getDo(Object request)
	{
		// TODO Auto-generated method stub
		return "/cmh/index.jsp";
	}

	@Override
	public Object postDo(Object request)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
