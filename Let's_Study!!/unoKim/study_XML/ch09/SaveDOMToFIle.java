package unoKim.study_XML.ch09;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class SaveDOMToFIle
{

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException
	{
		// TODO Auto-generated method stub
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setIgnoringElementContentWhitespace(true);
		DocumentBuilder builder = factory.newDocumentBuilder();
		// 문서 파싱하기
		Document document = builder.parse("Let's_Study!!/unoKim/study_XML/ch09/bml.xml");
		// 변환기 생성
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		transformer.setOutputProperty(OutputKeys.ENCODING, "euc-kr");
		transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "bml.dtd");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");

		// DOMSource 객체 생성
		DOMSource source = new DOMSource(document);
		// StreamResult 객체 생성
		StreamResult result = new StreamResult(new File("Let's_Study!!/unoKim/study_XML/ch09/new.xml"));
		// 파일로 저장하기
		transformer.transform(source, result);
		System.out.println("Let's_Study!!/unoKim/study_XML/ch09/new.xml 로 저장되었습니다");
	}
}
