package controller.main;

import javax.xml.ws.spi.http.HttpHandler;

import controller.methodFactory;
import server.HttpRequest;

public class unoMain implements methodFactory
{

	@Override
	public Object getDo(HttpRequest request)
	{
		// TODO Auto-generated method stub
		return "/uno/index.jsp";
	}

	@Override
	public Object postDo(HttpRequest request)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
