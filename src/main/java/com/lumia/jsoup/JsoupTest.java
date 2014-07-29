package com.lumia.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class JsoupTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//
//		String html = "<html><head><title>First parse</title></head>"
//				+ "<body><p>Parsed HTML into a doc.</p></body></html>";
//		Document doc = Jsoup.parse(html);
//		System.out.println(doc);
		
		String html = "<div><p>Lorem ipsum.</p>";
		Document doc = Jsoup.parseBodyFragment(html);
		Element body = doc.body();
		System.out.println(body);
	}

}
