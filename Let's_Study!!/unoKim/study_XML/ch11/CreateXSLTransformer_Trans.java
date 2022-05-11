package unoKim.study_XML.ch11;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;

public class CreateXSLTransformer_Trans
{

	public static void main(String[] args) throws TransformerConfigurationException
	{
		// TODO Auto-generated method stub
		TransformerFactory factory = TransformerFactory.newInstance();
		Source sourceXSL = new StreamSource("Let's_Study!!/unoKim/study_XML/ch11/bml.xsl");
		Transformer transformer = factory.newTransformer(sourceXSL);
		System.out.println("XSL이 적용된 XSL 변환기 객체 생성 성공");
	}

}
