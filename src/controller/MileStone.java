package controller;

import java.lang.reflect.Method;

import server.HttpRequest;

public class MileStone
{
	public static HttpRequest checkUrlAndHandle(HttpRequest request) throws Exception
	{
		for (urlStorege str : urlStorege.values())
		{
			if(request.getPath().equalsIgnoreCase(str.toString()))
			{
				Class<?> testClass = Class.forName(str.getValue());
				Object newObj = testClass.newInstance();
				Method method = testClass.getDeclaredMethod("getDo", HttpRequest.class);
				return (HttpRequest) method.invoke(newObj, request);
			}
		}
		return request;
	}
}
