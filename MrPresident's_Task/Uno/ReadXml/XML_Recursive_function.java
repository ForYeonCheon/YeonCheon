package Uno.ReadXml;

import java.io.File;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class XML_Recursive_function
	{
		public static void main(String[] args) throws Exception
		{
			LinkedList<String> lkList = new LinkedList<String>();
			
			String directoryName = System.getProperty("user.dir") + "\\MrPresident's_Task\\Uno\\ReadXml\\XmlFiles\\";
			File XML = new File(directoryName + "A-server.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = dbf.newDocumentBuilder();
			Document xmldoc = parser.parse(XML);
			Element root = xmldoc.getDocumentElement();
			String welcome = "| $$$ WELCOME TO DIABLO 4  $$$ This " + root.getTagName() + " : " + root.getAttribute("id") + "|";
			System.out.println(welcome);
			for (int i = 0; i < welcome.length(); i++)
				System.out.print("-");
			System.out.println();
			getNode(root);
		}

		public static void getNode(Node n)
		{
			for (int i = 0; i < n.getChildNodes().getLength(); i++)
			{
				if (n.getChildNodes().item(i).getNodeType() == Node.ELEMENT_NODE)
				{
					Element eElement = (Element) n.getChildNodes().item(i);
					String cData = null;
					if (eElement.hasAttributes())
					{
						NamedNodeMap nas = eElement.getAttributes();
						System.out.print(n.getChildNodes().item(i).getNodeName());
						for (int j = 0; j < nas.getLength(); j++)
						{
							cData = nas.item(j).toString().split("=")[0];
							System.out.print(" " + cData + " : " + eElement.getAttribute(cData));
						}
						System.out.println();
					}
					else
					{
						System.out.print(n.getChildNodes().item(i).getNodeName() + " : ");
					}
					getNode(n.getChildNodes().item(i));
				}
				else
					if (n.getChildNodes().item(i).getNodeType() == Node.TEXT_NODE && n.getChildNodes().item(i).getNodeValue().trim().length() != 0)
					{
						if (!n.getChildNodes().item(i).getNodeValue().equals("") && n.getChildNodes().item(i).getNodeValue().length() != 0)
						{
							System.out.println(n.getChildNodes().item(i).getNodeValue());
						}
					}
					else
					{
						if (n.getChildNodes().item(i).getNextSibling() == null || n.getChildNodes().item(i).getNextSibling().getNodeValue() == null)
						{
							if (n.hasChildNodes())
							{
								System.out.println(n);
							}
						}
					}
			}
		}
	}
