package unoKim.study_XML.ch12;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

public class UsingDynamicSchema
{

	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		boolean isValidSchema = false;
		Source sourceXmlSchema = new StreamSource("Let's_Study!!/unoKim/study_XML/ch12/booklist_dynamic_schema.xml");
		Source[] sourceXsdSchema = new Source[]{new StreamSource("Let's_Study!!/unoKim/study_XML/ch12/booklist_schema.xsd")};
		isValidSchema = ValidatorUtil.validateXmlSchema(sourceXmlSchema, sourceXsdSchema);
		if (isValidSchema)
		{
			System.out.println("해당 동적파일은 스키마가 유효함");
		}
		else
		{
			System.out.println("해당 동적파일은 스키마가 유효하지 않음");
		}
		Source sourceXmlDtd = new StreamSource("Let's_Study!!/unoKim/study_XML/ch12/booklist_dynamic_schema.xml");
		Source[] sourceXsdDtd = new Source[]{new StreamSource("Let's_Study!!/unoKim/study_XML/ch12/booklist.dtd")};
		isValidSchema = ValidatorUtil.validateXmlSchema(sourceXmlDtd, sourceXsdDtd);
		if (isValidSchema)
		{
			System.out.println("해당 동적파일은 DTD가 유효함");
		}
		else
		{
			System.out.println("해당 동적파일은 DTD가 유효하지 않음");
		}
	}

}
