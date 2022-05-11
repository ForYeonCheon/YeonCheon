package unoKim.study_XML.ch11;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;

public class MyContentHandler
{
	public static void main(String[] args)
	{
	}
}
class qwe
{

}
class CreateXSLTransformer_NoTrans
{
	public static void main(String[] args) throws Exception
	{
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transeformer = factory.newTransformer();
		System.out.println("XSL 이 없는 XSL 변환기 객체 생성성공");
	}
}