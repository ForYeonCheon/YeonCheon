package controller;

import java.lang.reflect.Method;

import server.HttpRequest;

public class MileStone
{
	public static Object checkMileStone(HttpRequest request) throws Exception
	{
		for (urlStorege str : urlStorege.values())
		{
			if(request.getPath().equalsIgnoreCase(str.toString()))
			{
				Class<?> testClass = Class.forName(str.getValue());
				Object newObj = testClass.newInstance();
				Method method = testClass.getDeclaredMethod("getDo", Object.class);
				return method.invoke(newObj, request);
			}
		}
		return "/";
	}
}
