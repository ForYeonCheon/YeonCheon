package controller;

import server.HttpRequest;

public interface methodFactory
{
	public HttpRequest getDo(HttpRequest request) throws Exception;
	public HttpRequest postDo(HttpRequest request) throws Exception;
}
