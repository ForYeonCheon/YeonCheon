
import java.lang.reflect.Method;

import Uno.src.server.HttpRequest;
import Uno.src.controller.urlStorege;

public class MileStone {
	public static HttpRequest checkUrlAndHandle(HttpRequest request) throws Exception {
		for (urlStorege str : urlStorege.values()) {
			if (request.getPath().equalsIgnoreCase(str.toString())) {
				Class<?> testClass = Class.forName(str.getValue());
				Object newObj = testClass.newInstance();
				if (request.getMethod().equalsIgnoreCase("get")) {
					Method method = testClass.getDeclaredMethod("getDo", HttpRequest.class);
					return (HttpRequest) method.invoke(newObj, request);
				} else { // 포스트는 나중에..
					Method method = testClass.getDeclaredMethod("getPost", HttpRequest.class);
					return (HttpRequest) method.invoke(newObj, request);
				}
			}
		}
		return request;
	}
}
