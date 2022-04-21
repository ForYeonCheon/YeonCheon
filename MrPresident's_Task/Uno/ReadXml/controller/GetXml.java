package Uno.ReadXml.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class GetXml {

	private Map<String, Map<String, String>> userInfo;

	public GetXml() {
		this.userInfo = new HashMap<>();
		this.setUserInfo();
	}

	public Map<String, Map<String, String>> getUserInfo() {
		return userInfo;
	}

	private void setUserInfo() {
		try {
			String directoryName = System.getProperty("user.dir") + "\\MrPresident's_Task\\Uno\\ReadXml\\XmlFiles\\";
			File file = new File(directoryName + "Diablo4.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse(file);
			document.getDocumentElement().normalize();
			NodeList nList = document.getElementsByTagName("userId");
			String userId = null;

			Map<String, String> idMap = new HashMap<>();
			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					userId = eElement.getAttribute("id");
					idMap.put("password", eElement.getElementsByTagName("password").item(0).getTextContent());
					idMap.put("name", eElement.getElementsByTagName("name").item(0).getTextContent());
					idMap.put("server", eElement.getElementsByTagName("server").item(0).getTextContent());
					idMap.put("userId", eElement.getAttribute("id"));
					Map<String, String> cloneMap = new HashMap<>(idMap);
					this.userInfo.put(userId, cloneMap);
					idMap.clear();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
