package controller.main;

import controller.methodFactory;
import server.HttpRequest;

public class hhjMain implements methodFactory
{

	@Override
	public HttpRequest getDo(HttpRequest request)
	{
		// TODO Auto-generated method stub

		request.setResponseContents("/hhj/index.jsp");
		return request;
	}

	@Override
	public HttpRequest postDo(HttpRequest request)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
