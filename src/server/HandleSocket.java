package server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import controller.MileStone;

public class HandleSocket
{
	public void excute(Socket client) throws Exception
	{
		OutputStream out = client.getOutputStream(); // 클라이언트에게 데이터를 보내기 위한 작업
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));

		InputStream in = client.getInputStream(); // 클라이언트에게서 받은 데이터를 처리를 위한 작업
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String line = null;
		HttpRequest request = new HttpRequest();
		line = br.readLine();
		String[] firstLineArgs = line.split(" ");
		request.setMethod(firstLineArgs[0]);
		request.setPath(firstLineArgs[1]);
		if(request.getMethod().equalsIgnoreCase("get"))
		{
			if(request.getPath().contains("?"))
			{
				String[] tmpArr = request.getPath().split("\\?");
				if(tmpArr[0].startsWith("/"))
				{
					tmpArr[0].replaceFirst("/", "");
					request.setPath(tmpArr[0]);
				}
			}
			else
			{
				if(request.getPath().startsWith("/") && request.getPath().length() > 1)
				{
					String tmp = request.getPath().replaceFirst("/", "");
					request.setPath(tmp);
				}
			}
			String path = (String) MileStone.checkMileStone(request.getPath(), null);
			request.setPath(path);
		}

		while ((line = br.readLine()) != null)
		{
			if("".equals(line))
			{ // 헤더를 읽고 빈줄을 만나면
				break;
			}
			String[] headerArray = line.split(" ");
			if(headerArray[0].startsWith("Host:"))
			{
				request.setHost(headerArray[1].trim());
			}
			else
				if(headerArray[0].startsWith("Content-Length:"))
				{
					int length = Integer.parseInt(headerArray[1].trim());
					request.setContentLength(length);
				}
				else
					if(headerArray[0].startsWith("User-Agent:"))
					{
						request.setUserAgent(line.substring(12));
					}
					else
						if(headerArray[0].startsWith("Content-Type:"))
						{
							request.setContentType(headerArray[1].trim());
						}
		}
		System.out.println(request);

		String path = System.getProperty("user.dir");
		String[] tmp = path.split("src");
		path = tmp[0] + "\\src\\view";

		String baseDir = path;
		String fileName = request.getPath();

		if("/".equals(fileName))
		{
			fileName = "/main/index.jsp";
		}
		else
			if(fileName.endsWith(".png"))
			{ // png 이미지일때
				fileName = request.getPath();
			}
		fileName = baseDir + fileName;
		System.out.println();
		System.out.println(fileName);

		String contentType = "text/html; charset=UTF-8";
		if(fileName.endsWith(".png"))
		{
			contentType = "image/png";
		}

		File file = new File(fileName); // java.io.File
		long fileLength = file.length();

		if(file.isFile())
		{
			pw.println("HTTP/1.1 200 OK");
			pw.println("Content-Type: " + contentType);
			pw.println("Content-Length: " + fileLength);
			pw.println();
		}
		else
		{
			pw.println("HTTP/1.1 404 OK");
			pw.println("Content-Type: " + contentType);
			pw.println("Content-Length: " + fileLength);
			pw.println();
		}

		pw.flush(); // 헤더와 빈줄을 char형식으로 출력

		@SuppressWarnings("resource")
		FileInputStream fis = new FileInputStream(file);
		byte[] buffer = new byte[1024];
		int readCount = 0;
		while ((readCount = fis.read(buffer)) != -1)
		{
			out.write(buffer, 0, readCount);
		}
		out.flush();

		out.close();
		in.close();
		client.close(); // 클라이언트와 접속이 close된다.
	}
}
