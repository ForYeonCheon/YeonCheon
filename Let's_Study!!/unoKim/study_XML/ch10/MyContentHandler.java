package unoKim.study_XML.ch10;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class MyContentHandler implements ContentHandler
{
	public void setDocumentLocator(Locator locator)
	{
	}
	public void startDocument() throws SAXException
	{

	}
	public void endDocument() throws SAXException
	{

	}
	public void startPrefixMapping(String prefix, String url)
	{

	}
	public void endElement(String uri, String localName, String qName)
	{
		System.out.println();
	}
	public void startElement(String uri, String localName, String qName, Attributes atts)
	{
		if (qName.equals("booklist"))
		{
			System.out.println(qName);
		}
		else
			if (qName.equals("book"))
			{
				System.out.println("-----------------------------");
				System.out.println("kind : " + atts.getValue("kind"));
			}
			else
			{
				System.out.print(qName + " : ");
			}
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	public void characters(char[] ch, int start, int length)
	{
		String content = new String(ch, start, length);
		System.out.println(content);
	}
	public void processingInstruction(String target, String data)
	{

	}
	public void skippedEntity(String name)
	{

	}
	public void endPrefixMapping(String prefix) throws SAXException
	{
		// TODO Auto-generated method stub

	}
	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException
	{
		// TODO Auto-generated method stub

	}
}
