package unoKim.study_XML.ch10;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.XMLReader;

public class SettingContentHandler
{

	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		XMLReader reader = parser.getXMLReader();
		org.xml.sax.ContentHandler contentHandler = new MyContentHandler();
		reader.setContentHandler(contentHandler);
		reader.parse("Let's_Study!!/unoKim/study_XML/ch09/bml.xml");
	}

}
