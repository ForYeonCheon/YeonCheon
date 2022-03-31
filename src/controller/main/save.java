package controller.main;

import java.io.File;
import java.io.FileWriter;

import controller.methodFactory;
import server.HttpRequest;

public class save implements methodFactory
{

	@Override
	public HttpRequest getDo(HttpRequest request) throws Exception
	{
		// TODO Auto-generated method stub
		String path = System.getProperty("user.dir");
		String[] tmp = path.split("src");
		path = tmp[0] + "\\DB\\page\\uno.txt";
		File file = new File(path);
		FileWriter fileWriter = new FileWriter(file, true);

		String contents = request.getContents();
		if(contents.contains("&"))
		{
			String[] tmpArr = contents.split("\\&");
			for (int i = 0; i < tmpArr.length; i++)
			{
				if(tmpArr[i].contains("="))
				{
					String[] inputArr = tmpArr[i].split("=");
					for (int j = 0; j < inputArr.length; j++)
					{
						fileWriter.write(inputArr[j]);
						if(j != (inputArr.length - 1)) fileWriter.write("|");
					}
					fileWriter.write("@");
				}
			}
		}
		fileWriter.flush();
		fileWriter.close();
		request.setResponseUrl(request.getPath());
		return request;
	}

	@Override
	public HttpRequest postDo(HttpRequest request)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
