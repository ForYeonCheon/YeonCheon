package controller;

import server.HttpRequest;

public interface methodFactory
{
	public Object getDo(HttpRequest request);
	public Object postDo(HttpRequest request);
}
