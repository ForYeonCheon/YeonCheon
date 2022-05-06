package unoKim.study_XML.ch09;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class ModifyFirstBook
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
		Element eBook = (Element) eRoot.getFirstChild();
		// 첫번째 책 제목 수정하기
		Element eTitle = (Element) eBook.getFirstChild();
		Text tTitle = (Text) eTitle.getFirstChild();
		tTitle.setData("프로그램 개발자를 위한 Eclipse");
		System.out.println("수정 후 제목 : " + tTitle.getData());
		// 첫번째 책 종류 수정하기
		eBook.setAttribute("kind", "컴퓨터");
		System.out.println("수정후 종류 : " + eBook.getAttribute("kind"));
	}
}
