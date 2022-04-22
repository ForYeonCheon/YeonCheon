package Uno.ReadXml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLtest {
	public static void main(String[] args) {
		try {
			XMLDOMdata();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void XMLDOMdata() throws Exception {
		String directoryName = System.getProperty("user.dir") + "\\MrPresident's_Task\\Uno\\ReadXml\\XmlFiles\\";
		File XML = new File(directoryName + "A-server.xml");
		DocumentBuilder builder;
		DocumentBuilderFactory factory;
		Document document;
		factory = DocumentBuilderFactory.newInstance();
		builder = factory.newDocumentBuilder();
		document = builder.parse(XML);
		document.getDocumentElement().normalize();
		NodeList nodeList = document.getElementsByTagName("*");
		int count = nodeList.getLength();
		findNode(nodeList, count);
		System.out.println("끝");
	}

	public static void findNode(NodeList nodeList, int length) throws Exception {
		for (int i = 0; i < length; i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				if (element.hasChildNodes()) {
					NodeList childNodeList = element.getElementsByTagName("*");
					int childLength = childNodeList.getLength();
					findNode(childNodeList, childLength);
				}
				System.out.println(node.getNodeName());
				System.out.println(":" + node.getTextContent());
			}
		}
	}
}