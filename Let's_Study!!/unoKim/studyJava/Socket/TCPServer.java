package unoKim.studyJava.Socket;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer
{
	public static void main(String[] args) throws Exception
	{
		int port = Integer.parseInt("8070");
		ServerSocket serversocket = new ServerSocket(port);
		System.out.println("서버 실행중");
		while (true)
		{
			Socket socket = serversocket.accept();// d연결수락
			OutputStream outStream = socket.getOutputStream();// 소켓출ㄹ력 스트림 생성
			DataOutputStream dataOutPutStream = new DataOutputStream(outStream);// 스트림
																				// 변환
			for (int i = 1; i <= 5; i++)
			{
				dataOutPutStream.writeInt(i);
			}
			socket.close();
		}
	}
}
