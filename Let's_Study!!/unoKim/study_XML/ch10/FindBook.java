package unoKim.study_XML.ch10;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class FindBook
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		try
		{
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			System.out.println("1) 책 제목으로 검색 : 제목에 JSP 가 있는 책");
			System.out.println("-------------------------------------------");
			FindBookEventHandler handler = new FindBookEventHandler("title", "JSP");
			parser.parse("Let's_Study!!/unoKim/study_XML/ch09/bml.xml", handler);
			System.out.println("2) 책 종류로 검색 : 컴퓨터 종류");
			System.out.println("-------------------------------");
			handler = new FindBookEventHandler("kind", "컴퓨터");
			parser.parse("Let's_Study!!/unoKim/study_XML/ch09/bml.xml", handler);
		} catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
