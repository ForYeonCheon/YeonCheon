package Uno.ReadXml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class starter {

	public static void main(String[] args) throws Exception {
		starter starter = new starter();
		
		// TODO Auto-generated method stub
		try {
			String directoryName = System.getProperty("user.dir") + "\\MrPresident's_Task\\Uno\\ReadXml\\XmlFiles\\";
			File file = new File(directoryName + "Diablo4.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse(file);
			document.getDocumentElement().normalize();
			System.out.println("Root Element :" + document.getDocumentElement().getNodeName());
			NodeList nList = document.getElementsByTagName("userId");
			System.out.println("----------------------------");
			String id = null;
			String password = null;
			if (starter.checkUser(nList, id, password)) {
				System.out.println("로그인 성공");
			} else {
				System.out.println("로그인 실패");
			}
//			starter.checkUser(nList, id, password);
//			for (int temp = 0; temp < nList.getLength(); temp++) {
//				Node nNode = nList.item(temp);
//				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//					Element eElement = (Element) nNode;
//					if (eElement.getAttribute("id").equals("koria189")) {
//						System.out.println("Employee id : " + eElement.getAttribute("id"));
//						System.out.println(
//								"First Name : " + eElement.getElementsByTagName("password").item(0).getTextContent());
//						System.out.println(
//								"Last Name : " + eElement.getElementsByTagName("name").item(0).getTextContent());
//						System.out.println(
//								"Salary : " + eElement.getElementsByTagName("server").item(0).getTextContent());
//					}
//				}
//			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	boolean checkUser(final NodeList nList, String id, String passWord) {
		id = "koria189";
		passWord = "test1234";
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				if (eElement.getAttribute("id").equals(id)) {
					System.out.println("user id : " + eElement.getAttribute("id"));
					checkPassword(eElement, passWord);
					return true;
				}
			}
		}
		return false;
	}

	boolean checkPassword(Element eElement, String passWord) {
		if (eElement.getElementsByTagName("password").item(0).getTextContent().equals(passWord)) {
			return true;
		}
		return false;
	}

}