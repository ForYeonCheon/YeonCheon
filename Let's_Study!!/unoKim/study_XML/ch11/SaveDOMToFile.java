package unoKim.study_XML.ch11;

import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class SaveDOMToFile
{

	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setIgnoringElementContentWhitespace(true);
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("Let's_Study!!/unoKim/study_XML/ch11/bml.xsl");

		Element eRoot = document.getDocumentElement();
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.ENCODING, "eur-kr");

		Source source = new DOMSource(document);
		Result result = new StreamResult(new File("Let's_Study!!/unoKim/study_XML/ch11/bml-1.xml"));
		transformer.transform(source, result);

		System.out.println("bml-1.xml로 저장되었습니다");
	}

}
