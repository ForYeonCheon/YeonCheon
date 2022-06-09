package unoKim.studyJava.Socket;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class TCPClient
{
	public static void main(String[] args) throws Exception
	{
		String server = "127.0.0.1";
		int port = Integer.parseInt("8070");
		Socket socket = new Socket(server, port);
		InputStream is = socket.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		for (int i = 0; i < 5; i++)
		{
			int ims = dis.readInt();
			System.out.println("서버로 부터 받은 데이터 " + ims);
		}
		socket.close();
	}
}
