package controller;

import server.HttpRequest;

public interface methodFactory
{
	public HttpRequest getDo(HttpRequest request);
	public HttpRequest postDo(HttpRequest request);
}
