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

public class RemoveFIrstBook
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
		Element eBook = (Element) eRoot.getFirstChild();
		Element eTitle = (Element) eBook.getFirstChild();
		Text tTitle = (Text) eTitle.getFirstChild();
		String strTitle = tTitle.getData();
		System.out.println("제거전 첫번째 책 : " + strTitle);
		// 루트 엘리먼트의 첫번쨰 자식 엘리먼트인 book 엘리먼트 제거
		eBook = (Element) eRoot.getFirstChild();
		eRoot.removeChild(eBook);
		// 제거 후 루트 엘리먼트의 첫번째 자식 엘리먼트 정보 얻기
		eBook = (Element) eRoot.getFirstChild();
		eTitle = (Element) eBook.getFirstChild();
		tTitle = (Text) eTitle.getFirstChild();
		strTitle = tTitle.getData();
		System.out.println("제거 후 첫번째 책 : " + strTitle);
	}
}
