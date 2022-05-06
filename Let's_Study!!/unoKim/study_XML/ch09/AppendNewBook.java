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

public class AppendNewBook
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
		// book 엘리먼트 객체 생성
		Element eBook = document.createElement("book");
		// Title 엘리먼트 객체 생성
		Element eTitle = document.createElement("title");
		Text tTitle = document.createTextNode("부자아빠 가난한아빠");
		eTitle.appendChild(tTitle);
		// Author 엘리먼트 객체 생성
		Element eAuthor = document.createElement("author");
		Text tAuthor = document.createTextNode("로버트 기요사키");
		eAuthor.appendChild(tAuthor);
		// Publisher 엘리먼트 객체 생성
		Element ePublisher = document.createElement("publisher");
		Text tPublisher = document.createTextNode("황금가지");
		ePublisher.appendChild(tPublisher);
		// Price 엘리먼트 객체 생성
		Element ePrice = document.createElement("price");
		Text tPrice = document.createTextNode("12,000");
		ePrice.appendChild(tPrice);
		// 자식 엘리먼트 객체를 book 엘리먼트 객체에 붙이기
		eBook.appendChild(eTitle);
		eBook.appendChild(eAuthor);
		eBook.appendChild(ePublisher);
		eBook.appendChild(ePrice);
		// 속성 객체를 book엘리먼트 객체에 붙이기
		eBook.setAttribute("kind", "금융");
		eRoot.appendChild(eBook);
		System.out.println("추가성공");
		// 책 제목들만 뽑아오기
		System.out.println("추가 이후 최종 책 목록");
		NodeList nlTitle = eRoot.getElementsByTagName("title");
		for (int i = 0; i < nlTitle.getLength(); i++)
		{
			eTitle = (Element) nlTitle.item(i);
			tTitle = (Text) eTitle.getFirstChild();
			String strTitle = tTitle.getData();
			System.out.println("-" + strTitle);
		}
	}
}
