package unoKim.study_XML.ch12;

import org.xml.sax.InputSource;

public class UsingStaticSchema
{
	public static void main(String[] args) throws Exception
	{
		boolean isValidDTD = false;
		InputSource sourceXmlDtd = new InputSource("Let's_Study!!/unoKim/study_XML/ch12/booklist_dtd.xml");
		isValidDTD = ValidatorUtil.validateXml(sourceXmlDtd);
		if (isValidDTD)
		{
			System.out.println("Using DTD : 유효함");
		}
		else
		{
			System.out.println("Using DTD : 유효하지 않음");
		}
		boolean isValidSchema = true;
		InputSource sourceXmlSchema = new InputSource("Let's_Study!!/unoKim/study_XML/ch12/booklist_schema.xml");
		isValidSchema = ValidatorUtil.validateXml(sourceXmlSchema);
		if (isValidSchema)
		{
			System.out.println("Using XMLSchema : 유효함");
		}
		else
		{
			System.out.println("Using XMLSchema : 유효함");
		}
	}
}
