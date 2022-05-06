package unoKim.study_XML.ch09;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class CreateDOMParser_1
{
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		// DOM 파서 공장 생성
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try
		{
			DocumentBuilder parser = factory.newDocumentBuilder();
		} catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("Dom 파서 객체 생성 성공");
	}

}
