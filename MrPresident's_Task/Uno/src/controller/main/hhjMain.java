package Uno.src.controller.main;

import Uno.src.controller.methodFactory;
import Uno.src.server.HttpRequest;

public class hhjMain implements methodFactory {

	@Override
	public HttpRequest getDo(HttpRequest request) {
		// TODO Auto-generated method stub

		request.setResponseUrl("/hhj/index.jsp");
		return request;
	}

	@Override
	public HttpRequest postDo(HttpRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
