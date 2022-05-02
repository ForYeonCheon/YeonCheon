package unoKim.studyJava.Crawling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.w3c.dom.Document;
public class CrawlingNaverFins
{
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException
	{
		/* url 셋팅하고 파서셋팅하고, doc 셋팅하는 부분 */
		final String URL = "https://finance.naver.com/"; // <-- 가져올 url
		final String KOSPI = ".kospi_area";
		final String KOSDAQ = ".kosdaq_area";
		Document doc = Jsoup.connect(URL).get(); // <-- 해당부분에서 doc에 url의 HTML
													// 문서가 모두 들어가게 된다.
		/* 셋팅 부분 끝 */
		/* 입력할 자료구조를 설계 및 선언 */
		HashMap<String, ArrayList<String>> outMap = new HashMap<String, ArrayList<String>>();
		ArrayList<String> innerList = new ArrayList<String>();
		String header = "";
		String[] strArr = {};
		/* 설계 및 선언 종료 */
		/* 구분자를 통해 데이터들을 잘게 쪼갠다. */
		header = doc.select(KOSPI).select(".heading_area").select("a").get(0).text();
		strArr = doc.select(KOSPI).select(".heading_area").select("a").get(1).text().split(" ");
		/* 종료 */
		/* 각 자료구조형태에 데이터 삽입 */
		for (String inner : strArr)
			innerList.add(inner);
		outMap.put(header, (ArrayList<String>) innerList.clone());
		innerList.clear();

		header = doc.select(KOSDAQ).select(".heading_area").select("a").get(0).text();
		strArr = doc.select(KOSDAQ).select(".heading_area").select("a").get(1).text().split(" ");
		for (String inner : strArr)
			innerList.add(inner);
		outMap.put(header, (ArrayList<String>) innerList.clone());
		innerList.clear();
		/* 종료 */
		/* 리턴 및 확인 */
		System.out.println(outMap);
	}
}