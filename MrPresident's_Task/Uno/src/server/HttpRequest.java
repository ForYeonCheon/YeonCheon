package Uno.src.server;

public class HttpRequest
{
	private String method; // GET, POST, PUT, DELETE ....
	private String path;
	private String host; // host
	private int contentLength; // COntent-Length : body 길이
	private String userAgent; // User-Agent : 브라우저 정보
	private String contentType; // Content-Type : 사용자가 요청한 컨텐츠의 타입
	private String contents;
	private String responseUrl;
	private String responseContents;

	public String getContents()
	{
		return contents;
	}

	public void setContents(String contents)
	{
		this.contents = contents;
	}

	public String getResponseUrl()
	{
		return responseUrl;
	}

	public void setResponseUrl(String responseUrl)
	{
		this.responseUrl = responseUrl;
	}

	public String getResponseContents()
	{
		return responseContents;
	}

	public void setResponseContents(String responseContents)
	{
		this.responseContents = responseContents;
	}

	public String getMethod()
	{
		return method;
	}

	public void setMethod(String method)
	{
		this.method = method;
	}

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	public String getHost()
	{
		return host;
	}

	public void setHost(String host)
	{
		this.host = host;
	}

	public int getContentLength()
	{
		return contentLength;
	}

	public void setContentLength(int contentLength)
	{
		this.contentLength = contentLength;
	}

	public String getUserAgent()
	{
		return userAgent;
	}

	public void setUserAgent(String userAgent)
	{
		this.userAgent = userAgent;
	}

	public String getContentType()
	{
		return contentType;
	}

	public void setContentType(String contentType)
	{
		this.contentType = contentType;
	}

	@Override
	public String toString()
	{
		return "HttpRequest [method=" + method + ", path=" + path + ", host=" + host + ", contentLength=" + contentLength + ", userAgent=" + userAgent
				+ ", contentType=" + contentType + ", contents=" + contents + ", responseUrl=" + responseUrl + ", responseContents="
				+ responseContents + "]";
	}
}
