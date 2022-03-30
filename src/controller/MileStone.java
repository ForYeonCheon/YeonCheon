package controller;

import java.lang.reflect.Method;


public class MileStone
{
	public static Object checkMileStone(String url, Object request) throws Exception
	{
		for (urlStorege str : urlStorege.values())
		{
			if(url.equalsIgnoreCase(str.toString()))
			{
				Class<?> testClass = Class.forName(str.getValue());
				Object newObj = testClass.newInstance();
				Method method = testClass.getDeclaredMethod("getDo", Object.class);
				return method.invoke(newObj, request);
			}
		}
		return true;
	}
}
