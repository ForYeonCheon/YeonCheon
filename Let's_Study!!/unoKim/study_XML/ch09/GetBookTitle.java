package unoKim.study_XML.ch09;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class GetBookTitle
{

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException
	{
		// TODO Auto-generated method stub
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setIgnoringElementContentWhitespace(true);
		DocumentBuilder builder = factory.newDocumentBuilder();
		// 문서 파싱하기
		Document document = builder.parse("Let's_Study!!/unoKim/study_XML/ch09/bml.xml");
		// 루트 엘리먼트 참조 얻기
		Element eRoot = document.getDocumentElement();
		// 책 제목들만 뽑아오기
		NodeList nlTitles = eRoot.getElementsByTagName("title");
		for (int i = 0; i < nlTitles.getLength(); i++)
		{
			Element eTitle = (Element) nlTitles.item(i);
			Text tTitle = (Text) eTitle.getFirstChild();
			String strTitle = tTitle.getData();
			System.out.println(strTitle);
		}
	}
}
