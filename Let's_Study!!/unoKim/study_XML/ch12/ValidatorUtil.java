package unoKim.study_XML.ch12;

import javax.xml.XMLConstants;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;

public class ValidatorUtil implements ErrorHandler
{
	private static boolean result = true;
	public void warning(SAXParseException exception) throws SAXParseException
	{
	}
	public void error(SAXParseException exception) throws SAXParseException
	{
		ValidatorUtil.result = false;
	}
	public void fatalError(SAXParseException e) throws SAXParseException
	{
		ValidatorUtil.result = false;
	}
	public static boolean validateXml(InputSource sourceXml)
	{
		ValidatorUtil.result = true;
		try
		{
			SAXParserFactory factory = SAXParserFactory.newInstance();
			factory.setValidating(true);
			factory.setNamespaceAware(true);
			factory.setFeature("http://apache.org/xml/features/validation/schema", true);
			SAXParser parser = factory.newSAXParser();

			XMLReader reader = parser.getXMLReader();
			reader.setErrorHandler(new ValidatorUtil());
			reader.parse(sourceXml);
		} catch (Exception e)
		{
			ValidatorUtil.result = false;
		}
		return ValidatorUtil.result;
	}
	public static boolean validateXmlSchema(Source sourceXml, Source[] sourceXsd)
	{
		ValidatorUtil.result = true;
		try
		{
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory.newSchema(sourceXsd);
			Validator validator = schema.newValidator();
			validator.setErrorHandler(new ValidatorUtil());
			validator.validate(sourceXml);
		} catch (Exception e)
		{
			ValidatorUtil.result = false;
		}
		return ValidatorUtil.result;
	}
}
