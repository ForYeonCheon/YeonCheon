package controller.main;

import controller.methodFactory;
import server.HttpRequest;

public class cmhMain implements methodFactory
{

	@Override
	public HttpRequest getDo(HttpRequest request)
	{
		// TODO Auto-generated method stub
		request.setResponseContents("/cmh/index.jsp");
		return request;
	}

	@Override
	public HttpRequest postDo(HttpRequest request)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
