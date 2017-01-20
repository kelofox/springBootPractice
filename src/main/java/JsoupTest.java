import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String urlStr = "https://news.google.com.tw/news";
		try {
			parseData(urlStr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
	}
	
	public static void parseData(String urlPath) throws Exception{
		URL url = new URL(urlPath);
		Document xmlDoc = Jsoup.parse(url, 3000);
		Elements title = xmlDoc.select("title");
		//Elements newsTitle = xmlDoc.select("span.titletext");
		Elements newsTitle = xmlDoc.select("a");
		System.out.println(title.get(0).text());
		for(Element e : newsTitle){
			//e.getElementsByAttribute("alt").get(0).text();
			System.out.println(e.text());
		}
	}

}
