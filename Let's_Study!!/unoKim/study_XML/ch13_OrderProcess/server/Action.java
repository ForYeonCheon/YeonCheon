package unoKim.study_XML.ch13_OrderProcess.server;

import java.net.Socket;

import org.w3c.dom.Document;

public abstract class Action
{
	public abstract void execute(Socket sc, Document doc) throws Exception;
}
