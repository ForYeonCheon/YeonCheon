package unoKim.study_XML.ch11;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class DisplayToMonitor
{
	public static void main(String[] args) throws Exception
	{
		TransformerFactory factory = TransformerFactory.newInstance();
		Source sourceXSL = new StreamSource("Let's_Study!!/unoKim/study_XML/ch11/bml.xsl");
		Transformer transformer = factory.newTransformer(sourceXSL);
		transformer.setOutputProperty(OutputKeys.ENCODING, "euc-kr");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		Source sourceXML = new StreamSource("Let's_Study!!/unoKim/study_XML/ch11/bml.xml");
		Result resultXML = new StreamResult(System.out);
		transformer.transform(sourceXML, resultXML);
	}
}