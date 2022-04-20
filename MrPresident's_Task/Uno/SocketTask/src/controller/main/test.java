package controller.main;

import java.nio.file.Path;
import java.nio.file.Paths;

public class test
{
	public static void main(String[] args)
	{
		Path currentPath = Paths.get("");
		String path = currentPath.toAbsolutePath().toString();
		System.out.println("현재 작업 경로: " + path);

	}
}
