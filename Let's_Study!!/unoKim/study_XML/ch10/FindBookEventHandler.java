package unoKim.study_XML.ch10;

import java.util.Hashtable;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

@SuppressWarnings("rawtypes")
public class FindBookEventHandler extends DefaultHandler
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

	private boolean isBook, isTitle, isAuthor, isPublisher, isPrice;
	private String condition, keyWord;
	private Hashtable hash;
	private Attributes attributes;
	public FindBookEventHandler(String condition, String keyWord)
	{
		this.condition = condition;
		this.keyWord = keyWord;
		this.hash = new Hashtable();
	}
	@SuppressWarnings("unchecked")
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
	{
		if (qName.equals("book"))
		{
			this.isBook = true;
			String kind = attributes.getValue("kind");
			this.hash.put("kind", kind);
		}
		else if (qName.equals("title"))
		{
			this.isTitle = true;
		}
		else if (qName.equals("author"))
		{
			this.isAuthor = true;
		}
		else if (qName.equals("publisher"))
		{
			this.isPublisher = true;
		}
		else if (qName.equals("price"))
		{
			this.isPrice = true;
		}
	}
	public void characters(char[] ch, int start, int length) throws SAXException
	{
		String str = new String(ch, start, length).trim();
		if (this.isTitle)
		{
			this.hash.put("title", str);
			this.isTitle = false;
		}
		else if (this.isAuthor)
		{
			this.hash.put("author", str);
			this.isAuthor = false;
		}
		else if (this.isPublisher)
		{
			this.hash.put("publisher", str);
			this.isPublisher = false;
		}
		else if (this.isPrice)
		{
			this.hash.put("price", str);
			this.isPrice = false;
		}
	}
	public void endElement(String uri, String localName, String qName) throws SAXException
	{
		if (qName.equals("book"))
		{
			if (this.condition.equals("kind"))
			{
				String kind = (String) this.hash.get("kind");
				if (kind.indexOf(this.keyWord) != -1)
				{
					displayBookInfo();
				}
			}
			else if (this.condition.equals("author"))
			{
				String author = (String) this.hash.get("author");
				if (author.indexOf(this.keyWord) != -1)
				{
					displayBookInfo();
				}
			}
			else if (this.condition.equals("publisher"))
			{
				String publisher = (String) this.hash.get("publisher");
				if (publisher.indexOf(this.keyWord) != -1)
				{
					displayBookInfo();
				}
			}
			else if (this.condition.equals("price"))
			{
				String price = (String) this.hash.get("price");
				if (price.indexOf(this.keyWord) != -1)
				{
					displayBookInfo();
				}
			}
			this.hash.clear();
			this.isBook = false;
		}
	}
	public void displayBookInfo()
	{
		System.out.println("title : " + (String) this.hash.get("title"));
		System.out.println("author : " + (String) this.hash.get("author"));
		System.out.println("publisher : " + (String) this.hash.get("publisher"));
		System.out.println("price : " + (String) this.hash.get("price"));
		System.out.println("-------------------------------------------");
	}
	public void warning(SAXException e) throws Exception
	{
		throw new SAXException("warning 이벤트처리");
	}
	public void error(SAXParseException e) throws SAXException
	{
		System.out.println("DTD또는 XML Schema문서 구조에 위배됩니다.");
		System.out.println("유효하지 않은 문서입니다.");
		throw new SAXException("에러 이벤트 처리");
	}
	public void fatalError(SAXParseException e) throws SAXException
	{
		System.out.println("XML 권고안의 내용을 지키지 않습니다.");
		System.out.println("잘짜여진 XML 문서가 아닙니다.");
		throw new SAXException("fatalError 이벤트 처리;");
	}
}
