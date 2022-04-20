package Uno.src.controller.main;

import Uno.src.controller.methodFactory;
import Uno.src.server.HttpRequest;

public class jmMain implements methodFactory {

	@Override
	public HttpRequest getDo(HttpRequest request) {
		// TODO Auto-generated method stub
		request.setResponseUrl("/kjm/index.jsp");
		return request;
	}

	@Override
	public HttpRequest postDo(HttpRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
