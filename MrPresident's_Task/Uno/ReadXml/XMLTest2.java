package Uno.ReadXml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XMLTest2 {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String directoryName = System.getProperty("user.dir") + "\\MrPresident's_Task\\Uno\\ReadXml\\XmlFiles\\";
		File XML = new File(directoryName + "A-server.xml");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder parser = dbf.newDocumentBuilder();
		Document xmldoc = parser.parse(XML);
		Element root = xmldoc.getDocumentElement();
		System.out.println(root);
		getNode(root);
	}

	public static void getNode(Node n) {
		for (Node ch = n.getFirstChild(); ch != null; ch = ch.getNextSibling()) {
			if (ch.getNodeType() == Node.ELEMENT_NODE) {
				System.out.println(ch.getNodeName());
				getNode(ch);
			} else if (ch.getNodeType() == Node.TEXT_NODE && ch.getNodeValue().trim().length() != 0) {
				System.out.println(ch.getNodeValue());
			}
		}
	}
}
