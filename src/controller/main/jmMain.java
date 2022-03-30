package controller.main;

import controller.methodFactory;

public class jmMain implements methodFactory
{

	@Override
	public Object getDo(Object request)
	{
		// TODO Auto-generated method stub
		return "/kjm/index.jsp";
	}

	@Override
	public Object postDo(Object request)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
