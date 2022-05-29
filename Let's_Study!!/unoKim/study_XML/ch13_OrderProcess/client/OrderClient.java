package unoKim.study_XML.ch13_OrderProcess.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

@SuppressWarnings("serial")
public class OrderClient extends JFrame implements ActionListener
{
	public JTextArea txtRequestXml;
	public JTextArea txtResponseXml;
	public JButton btnSendRequestXml;
	public JButton btnRequestList, btnRequestOrder, btnRequestOrderView;
	public DocumentBuilderFactory parserFactory;
	public DocumentBuilder parser;
	public String xslFilePath;

	public OrderClient()
	{
		this.txtRequestXml = new JTextArea();
		this.txtResponseXml = new JTextArea();
		this.CreateParser();
		this.eventControll();
	}
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			Object obj = ae.getSource();
			if (obj == this.btnRequestList)
				this.btnRequestList_Click();
			if (obj == this.btnRequestOrder)
				this.btnRequestOrder_Click();
			if (obj == this.btnSendRequestXml)
				this.btnSendRequestXml_Click();
			if (obj == this.btnRequestOrderView)
				this.btnRequestOrderView_Click();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void CreateParser()
	{
		try
		{
			this.parserFactory = DocumentBuilderFactory.newInstance();
			this.parser = this.parserFactory.newDocumentBuilder();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void eventControll()
	{
		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
		this.btnRequestList.addActionListener(this);
		this.btnRequestOrder.addActionListener(this);
		this.btnSendRequestXml.addActionListener(this);
		this.btnRequestOrderView.addActionListener(this);
	}
	public void btnRequestList_Click() throws Exception
	{
		Document document = this.parser.newDocument();
		Element eRequest = document.createElementNS("http://www.wbshim.com/oml", "request");
		document.appendChild(eRequest);
		Element eAction = document.createElement("action");
		eAction.setTextContent("ListAction");
		eRequest.appendChild(eAction);
		this.xmlView(txtRequestXml, document);
		this.xslFilePath = "Let's_Study!!/unoKim/study_XML/ch13_OrderProcess/client/productlist.xsl";
	}
	public void btnRequestOrder_Click() throws Exception
	{
		// 새 돔객체 생성
		Document document = this.parser.newDocument();
		// <request> 생성
		Element eRequest = document.createElement("http://www.wbshim.com/oml");
		document.appendChild(eRequest);
		// <action> 생성
		Element eAction = document.createElement("action");
		eAction.setTextContent("OrderAction");
		eRequest.appendChild(eAction);
		// <Data> 생성
		Element eData = document.createElement("data");
		eRequest.appendChild(eData);
		// <order> 생성
		Element eOrder = document.createElement("order");
		eData.appendChild(eOrder);
		// <userId>생성
		Element eUserId = document.createElement("userId");
		eUserId.setTextContent("uno-Kim");
		eOrder.appendChild(eUserId);
		// <userName> 생성
		Element eUserName = document.createElement("userName");
		eUserName.setTextContent("김은호");
		eOrder.appendChild(eUserName);
		// <productName>생성
		Element eProductNm = document.createElement("productNm");
		eProductNm.setTextContent("디카");
		eOrder.appendChild(eProductNm);
		// <qty>생성
		Element eQty = document.createElement("qty");
		eQty.setTextContent("2");
		eOrder.appendChild(eQty);
		// 요청 XML 문서보기
		this.xmlView(txtRequestXml, document);
		// 응답 XML 변환용 XSL 지정
		this.xslFilePath = "";
	}
	public void btnSendRequestXml_Click() throws Exception
	{
		// 새 돔객체 생성
		Document document = this.parser.newDocument();
		// <request> 생성
		Element eRequest = document.createElementNS("http://www.wbshim.com/oml", "request");
		document.appendChild(eRequest);
		// <action>생성
		Element eAction = document.createElement("action");
		eAction.setTextContent("OrderViewAction");
		eRequest.appendChild(eAction);
		this.xmlView(txtRequestXml, document);
		this.xslFilePath = "Let's_Study!!/unoKim/study_XML/ch13_OrderProcess/client/orderView.xsl";
	}
	@SuppressWarnings("resource")
	public void btnRequestOrderView_Click() throws Exception
	{
		// 연결열기
		Socket socket = new Socket("localhost", 50003);
		// 요청 XML 문서 보내기
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		out.writeUTF(this.txtRequestXml.getText());
		// 응답 XML 문서받기
		DataInputStream in = new DataInputStream(socket.getInputStream());
		String responseXML = in.readUTF();
		// DOM 생성
		StringReader sr = new StringReader(responseXML);
		InputSource xmlInputSource = new InputSource(sr);
		Document document = this.parser.parse(xmlInputSource);
		this.xmlView(txtRequestXml, document);
		this.ieView();
		socket.close();
	}
	public void xmlView(JTextArea jta, Document doc) throws Exception
	{
		TransformerFactory tff = TransformerFactory.newInstance();
		Transformer tf = tff.newTransformer();
		tf.setOutputProperty(OutputKeys.INDENT, "yes");
		// XML 문서출력
		Source xmlSource = new DOMSource(doc);
		StringWriter sw = new StringWriter();
		Result xmlResult = new StreamResult(sw);
		tf.transform(xmlSource, xmlResult);
		jta.setText(sw.toString());

	}
	@SuppressWarnings("unused")
	public void ieView() throws Exception
	{
		if (this.xslFilePath == null)
			return;
		TransformerFactory tff = TransformerFactory.newInstance();
		Source xslSource = new StreamSource(this.xslFilePath);
		Transformer tf = tff.newTransformer(xslSource);
		StringReader reader = new StringReader(this.txtResponseXml.getText());
		Source xmlSOurce = new StreamSource(reader);
		Result xmlResult = new StreamResult("Let's_Study!!/unoKim/study_XML/ch13_OrderProcess/client/result.html");
		tf.transform(xmlSOurce, xmlResult);
		String command = "Let's_Study!!/unoKim/study_XML/ch13_OrderProcess/client/result.html";
		Process process = Runtime.getRuntime().exec(command);
	}

	public static void main(String[] args)
	{
		OrderClient oc = new OrderClient();
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(oc);
		} catch (Exception e)
		{
			oc.setSize(550, 470);
			oc.setVisible(true);
		}
	}
}
