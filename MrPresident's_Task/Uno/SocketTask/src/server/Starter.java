package server;

import java.net.ServerSocket;
import java.net.Socket;

public class Starter
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket listener = null;
		HandleSocket handleSocket = new HandleSocket();
		try
		{
			listener = new ServerSocket(6969);
			System.out.println("6969서버는 client를 기다립니다.");
			while (true)
			{
				Socket client = listener.accept(); // 블러킹 메소드.
				System.out.println(client);
				new Thread(() -> {
					try
					{
						handleSocket.excute(client);
					}
					catch (Exception ex)
					{
						ex.printStackTrace();
					}
				}).start();
			}

		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{ // finally부분에서 서버소켓을 close한다.
			try
			{
				listener.close();
			}
			catch (Exception e)
			{
			}
		}
	}
}
