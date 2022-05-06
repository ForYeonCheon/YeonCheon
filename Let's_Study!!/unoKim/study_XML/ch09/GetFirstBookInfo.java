package unoKim.study_XML.ch09;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class GetFirstBookInfo
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
		// 첫번쨰 book엘리먼트 속성 열기
		Element eBook = (Element) eRoot.getFirstChild();
		Element eTitle = (Element) eBook.getFirstChild();
		Text tTitle = (Text) eTitle.getFirstChild();
		String strTitle = tTitle.getData();
		System.out.println(strTitle);

		Element eAuthor = (Element) eTitle.getNextSibling();
		Text tAuthor = (Text) eAuthor.getFirstChild();
		String strAuthor = tAuthor.getData();
		System.out.println(strAuthor);

		Element ePublisher = (Element) eAuthor.getNextSibling();
		Text tPublisher = (Text) ePublisher.getFirstChild();
		String strPublisher = tPublisher.getData();
		System.out.println(strPublisher);

		Element ePrice = (Element) ePublisher.getNextSibling();
		Text tPrice = (Text) ePrice.getFirstChild();
		String strPrice = tPrice.getData();
		System.out.println(strPrice);
	}
}
