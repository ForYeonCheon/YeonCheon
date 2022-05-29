package unoKim.study_XML.ch13_OrderProcess.server;

import java.io.DataOutputStream;
import java.io.StringWriter;
import java.net.Socket;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;

public class ListAction extends Action
{
	@Override
	public void execute(Socket sc, Document doc) throws Exception
	{
		TransformerFactory tff = TransformerFactory.newInstance();
		Source xslSource = new StreamSource("Let's_Study!!/unoKim/study_XML/ch13_OrderProcess/server/productList.xsl");
		Transformer tf = tff.newTransformer(xslSource);
		// 응답XML 문서생성
		Source xmlSource = new StreamSource("Let's_Study!!/unoKim/study_XML/ch13_OrderProcess/server/productList.xml");
		StringWriter sw = new StringWriter();
		Result xmlResult = new StreamResult(sw);
		tf.transform(xmlSource, xmlResult);
		String responseXml = sw.toString();
		// 클라이언트로 응답 xml 보내기
		DataOutputStream out = new DataOutputStream(sc.getOutputStream());
		out.writeUTF(responseXml);
	}
}
