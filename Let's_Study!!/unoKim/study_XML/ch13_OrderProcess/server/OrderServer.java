package unoKim.study_XML.ch13_OrderProcess.server;

import java.io.DataInputStream;
import java.io.StringReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import unoKim.study_XML.ch12.ValidatorUtil;

public class OrderServer
{
	public DocumentBuilderFactory parserFactory;
	public DocumentBuilder parser;
	public OrderServer()
	{
		try
		{
			parserFactory = DocumentBuilderFactory.newInstance();
			parser = parserFactory.newDocumentBuilder();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void startServer() throws Exception
	{
		ServerSocket ss = new ServerSocket(50003);
		System.out.println("*---------------------------*");
		System.out.println("서버 구동");
		System.out.println("*---------------------------*");
		while (true)
		{
			Socket socket = ss.accept();
			DataInputStream in = new DataInputStream(socket.getInputStream());
			String requestXml = in.readUTF();
			// 요청 XML 문서 유효성 검사
			StringReader sr = new StringReader(requestXml);
			Source xmlSource = new StreamSource(sr);
			Source[] xsdSource = new Source[]{new StreamSource("Let's_Study!!/unoKim/study_XML/ch13_OrderProcess/util/oml.xsd")};
			if (ValidatorUtil.validateXmlSchema(xmlSource, xsdSource))
			{
			}
			sr = new StringReader(requestXml);
			InputSource xmlInputSource = new InputSource(sr);
			Document doc = parser.parse(xmlInputSource);
			// 요청 Action 얻기 : ListAction, OrderAction, OderViewAction
			NodeList nl = doc.getElementsByTagName("action");
			Element eAction = (Element) nl.item(0);
			String actionName = eAction.getTextContent();
			Class<?> actionClass = Class.forName("ch13_OrderProcess.server." + actionName);
			Action action = (Action) actionClass.newInstance();
			action.execute(socket, doc);
			socket.close();
		}
	}
	public static void main(String[] args)
	{
		try
		{
			new OrderServer().startServer();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
